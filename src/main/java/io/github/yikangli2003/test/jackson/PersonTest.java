package io.github.yikangli2003.test.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class PersonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Person person = new Person("John Smith", 10, Gender.MALE,
                new Address("New York", "2000"), Arrays.asList("eating", "sleeping"));

        System.out.println("Person string:");
        System.out.println(person.toString());
        System.out.println("\n");

        String jsonPerson = mapper.writeValueAsString(person);

        System.out.println("jsonPerson:");
        System.out.println(jsonPerson);
        System.out.println("\n");

        Person deserializedPerson = mapper.readValue(jsonPerson, Person.class);
        System.out.println("deserializedPerson:");
        System.out.println(deserializedPerson.toString());
        System.out.println("\n");
    }
}
