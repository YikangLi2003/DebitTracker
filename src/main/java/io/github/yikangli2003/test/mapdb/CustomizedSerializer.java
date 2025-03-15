package io.github.yikangli2003.test.mapdb;

import io.github.yikangli2003.test.jackson.Address;
import io.github.yikangli2003.test.jackson.Gender;
import io.github.yikangli2003.test.jackson.Person;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;
import org.mapdb.HTreeMap;

import java.util.Arrays;

public class CustomizedSerializer {
    public static void main(String[] args) throws Exception {
        storeTwoPersons();
        readAndShowData();
    }

    private static void storeTwoPersons() {
        DB db = DBMaker.fileDB("personTest.db").make();

        HTreeMap<String, Person> hTreeMap = db
                .hashMap("myTreeMap")
                .keySerializer(Serializer.STRING)
                .valueSerializer(new PersonSerializer())
                .create();

        Person personOne = new Person("John Smith", 21, Gender.MALE,
                new Address("New York", "2000"), Arrays.asList("eating", "sleeping"));

        Person personTwo = new Person("Xichun Zhang", 20, Gender.FEMALE,
                new Address("Shanghai", "576"), Arrays.asList("working", "sleeping"));

        hTreeMap.put("abc-123", personOne);
        hTreeMap.put("def-456", personTwo);

        db.close();

        System.out.println("Persons data stored in personTest.db");
    }

    private static void readAndShowData() {
        DB db = DBMaker.fileDB("personTest.db").make();
        HTreeMap<String, Person> map = db.hashMap("myTreeMap")
                .keySerializer(Serializer.STRING)
                .valueSerializer(new PersonSerializer())
                .open();

        Person personOne = (Person) map.get("abc-123");
        Person personTwo = (Person) map.get("def-456");

        db.close();

        System.out.println("Person One: " + personOne.toString());
        System.out.println("Person Two: " + personTwo.toString());
    }
}
