package io.github.yikangli2003.test.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import io.github.yikangli2003.test.jackson.*;
import org.mapdb.Serializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RecordTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        DB db = DBMaker.memoryDB().make();
        HTreeMap<Long, Store> myMap = db.
                hashMap("myMap").
                keySerializer(Serializer.LONG).
                valueSerializer(Serializer.JAVA).
                createOrOpen();

        myMap.put(1L, new Store("Store One", 3, new Address("Melbourne", "3000")));

        Store store = myMap.get(1L);

        System.out.println(store);
        System.out.println(mapper.writeValueAsString(store));

        db.close();
    }
}
