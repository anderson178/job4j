package ru.job4j.bank;



public class User implements Comparable {
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
