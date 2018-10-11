package ru.job4j.sort;

import org.junit.Test;
import ru.job4j.sortnumbertwo.ListCompare;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.10.2018
 */
public class ListCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenStringsAreEqualThenPositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Avanov",
                "Ivanov"
        );
        assertThat(rst, is(-1));
    }

    @Test
    public void whenStringsAreEqualThenPositive2() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Iva",
                "Ivana"
        );
        assertThat(rst, is(-1));
    }

    @Test
    public void whenStringsAreEqualThenNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, is(1));
    }

    @Test
    public void whenStringsAreEqualThenNegative2() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivana",
                "Ivan"
        );
        assertThat(rst, is(1));
    }

}
