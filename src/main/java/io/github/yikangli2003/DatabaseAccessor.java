package io.github.yikangli2003;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.util.HashSet;
import java.util.Set;

import io.github.yikangli2003.entity.*;

public class DatabaseAccessor {
    private static final DB database;
    private static final HTreeMap<String, User> idToUserMap;
    private static final HTreeMap<String, DebtRecord> idToDebtRecordMap;
    private static final HTreeMap<String, String> emailToUserIdMap;
    private static final HTreeMap<String, Set<String>> creatorUserIdToDebtRecordIdSetMap;
    private static final HTreeMap<String, Set<String>>  creditorUserIdToDebtRecordIdSetMap;
    private static final HTreeMap<String, Set<String>> debtorUserIdToDebtRecordIdSetMap;

    static {
        database = DBMaker.memoryDB().transactionEnable().make();

        idToUserMap = database.
                hashMap("id to user").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.JAVA).
                createOrOpen();

        idToDebtRecordMap = database.
                hashMap("id to debt record").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.JAVA).
                createOrOpen();

        emailToUserIdMap = database.
                hashMap("email to user id").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.STRING).
                createOrOpen();

        creatorUserIdToDebtRecordIdSetMap = database.
                hashMap("creator user id to debt record id set").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.JAVA).
                createOrOpen();

        creditorUserIdToDebtRecordIdSetMap = database.
                hashMap("creditor user id to debt record id set").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.JAVA).
                createOrOpen();

        debtorUserIdToDebtRecordIdSetMap = database.
                hashMap("debtor user id to debt record id set").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.JAVA).
                createOrOpen();
    }

    // The following methods only read data from database.

    public static User getUserById(User userWithId) {
        return idToUserMap.get(userWithId.getId());
    }

    public static DebtRecord getDebtRecordById(DebtRecord recordWithId) {
        return idToDebtRecordMap.get(recordWithId.getId());
    }

    public static User getUserByEmail(User userWithEmail) {
        return idToUserMap.get(userWithEmail.getEmail());
    }

    private static Set<DebtRecord> getDebtRecordsByUserId(
            User userWithId, HTreeMap<String, Set<String>> userIdToDebtRecordIdSet
    ) {
        Set<String> debtRecordIdSet = userIdToDebtRecordIdSet.get(userWithId.getId());
        Set<DebtRecord> debtRecordSet = new HashSet<>();

        if  (debtRecordIdSet == null) {
            return debtRecordSet;
        }

        for (String debtRecordId : debtRecordIdSet) {
            debtRecordSet.add(idToDebtRecordMap.get(debtRecordId));
        }

        return debtRecordSet;
    }

    public static Set<DebtRecord> getDebtRecordsByCreatorId(User creatorWithId) {
        return getDebtRecordsByUserId(creatorWithId, creatorUserIdToDebtRecordIdSetMap);
    }

    public static Set<DebtRecord> getDebtRecordsByCreditorId(User creditorWithId) {
        return getDebtRecordsByUserId(creditorWithId, creditorUserIdToDebtRecordIdSetMap);
    }

    public static Set<DebtRecord> getDebtRecordsByDebtorId(User debtorWithId) {
        return getDebtRecordsByUserId(debtorWithId, debtorUserIdToDebtRecordIdSetMap);
    }

    // The following methods involve writing operations.

    public static boolean insertUser(User user) {
        if (idToUserMap.containsKey(user.getId()) || emailToUserIdMap.containsKey(user.getEmail())) {
            return false;
        }

        try {
            idToUserMap.put(user.getId(), user);
            emailToUserIdMap.put(user.getEmail(), user.getId());
            database.commit();
            return true;
        } catch (Exception e) {
            database.rollback();
            return false;
        }
    }


}
