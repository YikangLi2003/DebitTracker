package io.github.yikangli2003.test.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

public class FileStoreAndRead {
    public static void main(String[] args) {
        DB db = DBMaker.fileDB("MapDB.db").make();
        HTreeMap myMap = db.hashMap("myMap").createOrOpen();
        myMap.put("Welcome message!", "Hello world!");

        String message = (String) myMap.get("Welcome message!");
        System.out.println(message);

        db.close();
    }
}
