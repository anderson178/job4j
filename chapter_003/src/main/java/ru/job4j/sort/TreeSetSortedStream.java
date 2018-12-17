package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetSortedStream {
    public Set<User> sort(List<User> listUsers) {
        return new TreeSet<>(listUsers.stream().collect(Collectors.toSet()));
    }
}
