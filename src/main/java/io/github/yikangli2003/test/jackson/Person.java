package io.github.yikangli2003.test.jackson;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private Gender gender;
    private Address address;
    private List<String> hobbies;

    public Person() {}

    public Person(String name, int age, Gender gender, Address address, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("name: ").append(name).append("\n");
        sb.append("age: ").append(age).append("\n");
        sb.append("gender: ").append(gender).append("\n");
        sb.append("address: ").append(address).append("\n");
        sb.append("hobbies: ").append(hobbies).append("\n");

        return sb.toString();
    }
}
