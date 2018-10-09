package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.10.2018
 */
public class TreeSetSortedTest {
    @Test
    public void sortTest() {
        TreeSetSorted tree = new TreeSetSorted();
        List<User> users = new ArrayList<User>(Arrays.asList(
                new User("Denis", 28),
                new User("Vadim", 24),
                new User("Alena", 29),
                new User("Alan", 18),
                new User("Petr", 17)
        ));
        Set<User> result = tree.sort(users);
        Set<User> expect = new TreeSet<User>(Arrays.asList(
                new User("Denis", 28),
                new User("Vadim", 24),
                new User("Alena", 29),
                new User("Alan", 18),
                new User("Petr", 17)
        ));

        assertThat(result, is(expect));

    }
}
