package io.github.yikangli2003.test.mapdb;

import io.github.yikangli2003.test.jackson.Address;
import io.github.yikangli2003.test.jackson.Gender;
import io.github.yikangli2003.test.jackson.Person;

import org.jetbrains.annotations.NotNull;
import org.mapdb.DataInput2;
import org.mapdb.DataOutput2;
import org.mapdb.Serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonSerializer implements Serializer<Person> {
    @Override
    public void serialize(@NotNull DataOutput2 dataOutput2, @NotNull Person person) throws IOException {
        dataOutput2.writeUTF(person.getName());
        dataOutput2.writeInt(person.getAge());
        dataOutput2.writeUTF(person.getGender().toString());
        dataOutput2.writeUTF(person.getAddress().getCity());
        dataOutput2.writeUTF(person.getAddress().getZipcode());
        dataOutput2.writeInt(person.getHobbies().size());
        for (String hobby : person.getHobbies()) {
            dataOutput2.writeUTF(hobby);
        }
    }

    @Override
    public Person deserialize(@NotNull DataInput2 dataInput2, int available) throws IOException {
        String name = dataInput2.readUTF();
        int age = dataInput2.readInt();
        Gender gender = Gender.valueOf(dataInput2.readUTF());
        Address address = new Address(dataInput2.readUTF(), dataInput2.readUTF());

        int hobbiesSize = dataInput2.readInt();
        List<String> hobbies = new ArrayList<>(hobbiesSize);
        for (int i = 0; i < hobbiesSize; i++) {
            hobbies.add(dataInput2.readUTF());
        }

        return new Person(name, age, gender, address, hobbies);
    }
}
