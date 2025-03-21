package io.github.yikangli2003.database;

import io.github.yikangli2003.database.entity.*;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.util.Set;

public class DatabaseAccessor {
    private static final DB database = DBMaker.memoryDB().transactionEnable().make();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<String, User> idToUserMap = database.
            hashMap("id to user").
            keySerializer(Serializer.STRING).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<String, DebtRecord> idToDebtRecordMap = database.
            hashMap("id to debt record").
            keySerializer(Serializer.STRING).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    @SuppressWarnings("unchecked")
    private static final HTreeMap<String, Set<ModificationLog>> debtRecordIdToModificationLogSetMap = database.
            hashMap("debt record id to modification log set").
            keySerializer(Serializer.STRING).
            valueSerializer(Serializer.JAVA).
            createOrOpen();

    // The following methods only read data from database.



    // The following methods involve writing operations.


}
