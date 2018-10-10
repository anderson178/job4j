package ru.job4j.sortnumbertwo;

public class Users {
    private final String name;
    private final int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Integer getLengthName() {
        return this.name.toCharArray().length;
    }

}
