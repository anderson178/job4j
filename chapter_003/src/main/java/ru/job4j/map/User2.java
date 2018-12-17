package ru.job4j.map;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 04.10.2018
 */

public class User2 {
    private int id;
    private String name;
    private String city;

    public User2(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
