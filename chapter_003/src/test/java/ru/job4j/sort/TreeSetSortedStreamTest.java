package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TreeSetSortedStreamTest {

    @Test
    public void sortTest() {
        TreeSetSortedStream tree = new TreeSetSortedStream();
        List<User> users = List.of(
                new User("Denis", 28),
                new User("Vadim", 24),
                new User("Alena", 29),
                new User("Alan", 18),
                new User("Petr", 17)
        );
        Set<User> result = tree.sort(users);
        Set<User> expect = Set.of(
                new User("Petr", 17),
                new User("Alan", 18),
                new User("Vadim", 24),
                new User("Denis", 28),
                new User("Alena", 29)
        );

        assertThat(result, is(expect));

    }
}
