package ru.job4j.sort;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.10.2018
 */
public class User implements Comparable<User> {
    private final String name;
    private final int age;

    @Override
    public int compareTo(User next) {
        return this.getAge() - next.getAge();
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
