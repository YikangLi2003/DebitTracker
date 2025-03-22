package io.github.yikangli2003.database;

import io.github.yikangli2003.database.entity.*;
import io.github.yikangli2003.database.framework.OperationResult;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.util.Set;
import java.util.UUID;

public class DatabaseAccessor {
    private static final DB database = DBMaker.memoryDB().transactionEnable().make();

    // Retrieve entities with IDs through the following maps.

    @SuppressWarnings("unchecked")
    private static final HTreeMap<UUID, User> idToUserMap = database.
            hashMap("id to user").
            keySerializer(Serializer.UUID).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<UUID, DebtRecord> idToDebtRecordMap = database.
            hashMap("id to debt record").
            keySerializer(Serializer.UUID).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<UUID, Set<ModificationLog>> debtRecordIdToModificationLogSetMap = database.
            hashMap("debt record id to modification log set").
            keySerializer(Serializer.UUID).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    // Retrieve entity IDs with values of corresponding attributes through the following maps.

    private static final HTreeMap<String, UUID> emailToUserIdMap = database.
            hashMap("email to user id").
            keySerializer(Serializer.STRING).
            valueSerializer(Serializer.UUID).
            createOrOpen();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<UUID, Set<UUID>> creatorUserIdToDebtRecordIdSetMap = database.
            hashMap("creator user id to debt record id set").
            keySerializer(Serializer.UUID).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<UUID, Set<UUID>> creditorUserIdToDebtRecordIdSetMap = database.
            hashMap("creditor user id to debt record id set").
            keySerializer(Serializer.UUID).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<UUID, Set<UUID>> debtorUserIdToDebtRecordIdSetMap = database.
            hashMap("debtor user id to debt record id set").
            keySerializer(Serializer.UUID).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    // Methods for data insertion, selection, update and deletion.

    public static OperationResult insertUser(User newUser) {
        if (idToUserMap.containsKey(newUser.id())) {
            return OperationResult.ENTITY_ALREADY_EXISTS;
        } else if (emailToUserIdMap.containsKey(newUser.email())) {
            return OperationResult.DUPLICATE_FIELD;
        }

        try {
            idToUserMap.put(newUser.id(), newUser);
            emailToUserIdMap.put(newUser.email(), newUser.id());
            database.commit();
            return OperationResult.SUCCESS;
        } catch (Exception e) {
            database.rollback();
            return OperationResult.ROLLBACK;
        }
    }

    public static OperationResult updateUser(User updatedUser) {
        if (!idToUserMap.containsKey(updatedUser.id())) {
            return OperationResult.ENTITY_DOES_NOT_EXIST;
        }

        try {
            if (!idToUserMap.get(updatedUser.id()).email().equals(updatedUser.email())) {}
        }
    }


}
