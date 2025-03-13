package io.github.yikangli2003.learn.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.NavigableSet;

public class TransactionTest {
    public static void main(String[] args) {
        DB db = DBMaker.memoryDB().transactionEnable().make();
        NavigableSet<String> set = db.treeSet("mytreeset").serializer(Serializer.STRING).createOrOpen();

        set.add("orange");
        set.add("apple");
        db.commit();
        System.out.println(set.size()); // now we have 2 items

        set.add("banana");
        System.out.println(set.size()); // now we have 3 items
        db.rollback(); // Since we haven't commit the transaction, rollback will cancel the addition of banana
        System.out.println(set.size()); // then we have 2 items as the set at the beginning
    }
}
