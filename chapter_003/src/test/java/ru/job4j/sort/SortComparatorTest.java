package ru.job4j.sort;

import org.junit.Test;
import ru.job4j.sortnumbertwo.ListSorted;
import ru.job4j.sortnumbertwo.Users;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.10.2018
 */

public class SortComparatorTest {
    @Test
    public void sortTestWhenLengthName() {
        List<Users> result = new ArrayList<>(Arrays.asList(
                new Users("Denis", 28),
                new Users("Vladislav", 24),
                new Users("Alena", 29),
                new Users("Zlan", 18),
                new Users("Petr", 17)
        ));
        ListSorted sort = new ListSorted();
        List<Users> expect = List.of(
                result.get(3),
                result.get(4),
                result.get(0),
                result.get(2),
                result.get(1)
        );
        result = sort.sortNameLength(result);
        assertThat(result, is(expect));
    }

    @Test
    public void sortTestWhenNameAge() {
        List<Users> result = new ArrayList<>(Arrays.asList(
                new Users("Petr", 28),
                new Users("Vladislav", 24),
                new Users("Denis", 29),
                new Users("Zlan", 18),
                new Users("Petr", 17)
        ));
        List<Users> expect = List.of(
                result.get(2),
                result.get(4),
                result.get(0),
                result.get(1),
                result.get(3)
        );
        ListSorted sort = new ListSorted();
        result = sort.sortNameAge(result);
        assertThat(result, is(expect));
    }
}
