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
        User temp;
        int index = 0;
        while (index <= listUsers.size()) {
            for (int i = 0; i < listUsers.size() - 1; i++) {
                if (listUsers.get(i).compareTo(listUsers.get(i + 1)) > 0) {
                    temp = listUsers.get(i);
                    listUsers.set(i, listUsers.get(i + 1));
                    listUsers.set(i + 1, temp);
                } else {
                    index++;
                }
            }
        }
        return new TreeSet<>(listUsers);
    }

}

