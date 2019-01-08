package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.01.2019
 */

public class TreeSetSortedStream {
    public Set<User> sort(List<User> listUsers) {
        return new TreeSet<>(listUsers.stream().collect(Collectors.toSet()));
    }
}
