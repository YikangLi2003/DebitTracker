package io.github.yikangli2003.learn.mapdb;

import org.mapdb.DBMaker;
import org.mapdb.DB;
import org.mapdb.Serializer;

import java.util.NavigableSet;

public class NavigableSetTest {
    public static void main(String[] args) {
        DB db = DBMaker.memoryDB().make();
        NavigableSet<String> set = db
                .treeSet("mySet")
                .serializer(Serializer.STRING)
                .createOrOpen();
        set.add("wiw");
        System.out.println(set.getFirst());
        db.close();
    }
}
