package io.github.yikangli2003.learn.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

public class SerializerTest {
    public static void main(String[] args) {
        DB database = DBMaker.memoryDB().make();
        HTreeMap<String, Long> map = database.
                hashMap("map").
                keySerializer(Serializer.STRING).
                valueSerializer(Serializer.LONG).
                createOrOpen();

        map.put("apple", 12345L);
        map.put("banana", 6789L);

        System.out.println("apple: " + map.get("apple"));

        database.close();
    }
}
