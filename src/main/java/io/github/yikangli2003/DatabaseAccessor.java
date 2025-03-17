package io.github.yikangli2003;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class DatabaseAccessor {
    private static DB db = DBMaker.memoryDB().transactionEnable().make();

    private static void initializeDataStructures() {
        // map and set

        // map(user id, user)
        // map(debt record id, debt record)
        // map(user id, set(debt record id))

    }


}
