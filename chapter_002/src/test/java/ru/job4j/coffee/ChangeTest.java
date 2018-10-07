package ru.job4j.coffee;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.10.2018
 */
public class ChangeTest {
    @Test
    public void changeTest1() {
        Change change = new Change(50, 37);
        int[] result = change.changes();
        int[] expect = {10, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void changeTest2() {
        Change change = new Change(123, 37);
        int[] result = change.changes();
        int[] expect = {10, 10, 10, 10, 10, 10, 10, 10, 5, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void changeTest3() {
        Change change = new Change(100, 45);
        int[] result = change.changes();
        int[] expect = {10, 10, 10, 10, 10, 5};
        assertThat(result, is(expect));
    }
}
