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

    @Override
    public boolean equals(Object o) {
        boolean rst = false;
        if (this == o) {
            rst = true;
        }
        if (!(o instanceof User)) {
            rst = false;
        }
        User user = (User) o;
        rst = Objects.equals(this.name, user.name) && Objects.equals(this.passport, user.passport);
        return rst;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, passport);
    }

    public int getPassport() {
        return this.passport;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + this.name + '\'' + ", passport=" + this.passport + '}';
    }
}
