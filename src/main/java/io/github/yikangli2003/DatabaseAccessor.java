package io.github.yikangli2003;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import io.github.yikangli2003.entity.*;
import org.mapdb.Serializer;

public class DatabaseAccessor {
    private static final DB database;
    private static final HTreeMap<String, User> userMap;
    private static final HTreeMap<String, DebtRecord> debtRecordMap;

    static {
        database = DBMaker.memoryDB().transactionEnable().make();
        userMap = database.
                hashMap("users").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.JAVA).
                createOrOpen();


    }

    private static void initializeDataStructures() {
        // map and set

        // map(user id, user)
        // map(debt record id, debt record)
        // map(user id, set(debt record id))

    }


}
