package io.github.yikangli2003;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class DatabaseAccessor {
    private static DB db = DBMaker.memoryDB().transactionEnable().make();

    private static void initializeContainers() {

    }


}
