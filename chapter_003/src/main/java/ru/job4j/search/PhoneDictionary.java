package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 30.09.2018
 */

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<Person>();

    /**
     * метод добавления person в список
     *
     * @param person - человек
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод поиска по ключу в каждом из полей
     *
     * @param key - ключ поиска
     * @return - список с совпдающими значениями по заданному ключу
     */
    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
