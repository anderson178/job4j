package ru.job4j.task;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 30.11.2018
 */

public class TestSortDepartament {

    @Test
    public void whenSortDownWithOutDepartamaents() {
        SortTreeSetDepartament dep = new SortTreeSetDepartament();
        TreeSet<String> result = dep.sortDown(List.of("K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1"));
        List<String> expectation = List.of("K2", "K2\\SK1", "K2\\SK1\\SSK1", "K1",
                "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2");
        assertThat(result.toString(), is(expectation.toString()));
    }

    @Test
    public void whenSortUpWithOutDepartamaents() {
        SortTreeSetDepartament dep = new SortTreeSetDepartament();
        TreeSet<String> result = dep.sortUp(List.of("K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1"));
        List<String> expectation = List.of("K1", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1");
        assertThat(result.toString(), is(expectation.toString()));
    }


    @Test
    public void whenSortUpDepartaments() {
        SortTreeSetDepartament dep = new SortTreeSetDepartament();
        TreeSet<String> result = dep.sortUp(List.of("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K2\\SK1", "K1\\SK1\\SSK1", "K2", "K3", "K3\\SK1"
        ));
        List<String> expectation = List.of("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K3", "K3\\SK1");
        assertThat(result.toString(), is(expectation.toString()));
    }

    @Test
    public void whenTreeSetDown() {
        SortTreeSetDepartament dep = new SortTreeSetDepartament();
        TreeSet<String> result = dep.sortDown(List.of("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K2\\SK1", "K1\\SK1\\SSK1", "K2", "K3", "K3\\SK1"));
        List<String> expectation = List.of("K3", "K3\\SK1", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K1",
                "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1");
        assertThat(result.toString(), is(expectation.toString()));
    }

}
