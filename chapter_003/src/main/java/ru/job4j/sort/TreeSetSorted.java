package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.10.2018
 */
public class TreeSetSorted {

    /**
     * метод конвертирования коллекции объектов User в TreeSet
     *
     * @param listUsers - коллекция объектов User
     * @return
     */
    public Set<User> sort(List<User> listUsers) {
        return new TreeSet<User>(listUsers);
    }

}

