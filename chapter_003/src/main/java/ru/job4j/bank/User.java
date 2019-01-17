package ru.job4j.bank;


import java.util.Objects;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.10.2018
 */
public class User {
    private String name;
    private Integer passport;

    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    public int getPassport() {
        return this.passport;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + this.name + '\'' + ", passport=" + this.passport + '}';
    }
}
