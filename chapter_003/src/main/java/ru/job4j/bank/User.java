package ru.job4j.bank;


import java.util.Objects;

public class User implements Comparable{
    private String name;
    private int passport;

    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return passport == user.passport &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, passport);
    }

    public String getName() {
        return name;
    }

    public int getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.name + '\'' +
                ", passport=" + this.passport +
                '}';
    }
}
