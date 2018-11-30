package ru.job4j.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

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
        TreeSet<String> result = dep.sortDown(Arrays.asList("K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1"));
        ArrayList<String> expectation = new ArrayList<>(Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK1", "K1",
                "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2"));
        assertThat(result.toString(), is(expectation.toString()));
    }

    @Test
    public void whenSortUpWithOutDepartamaents() {
        SortTreeSetDepartament dep = new SortTreeSetDepartament();
        TreeSet<String> result = dep.sortUp(Arrays.asList("K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1"));
        ArrayList<String> expectation = new ArrayList<>(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1"));
        assertThat(result.toString(), is(expectation.toString()));
    }


    @Test
    public void whenSortUpDepartaments() {
        SortTreeSetDepartament dep = new SortTreeSetDepartament();
        TreeSet<String> result = dep.sortUp(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K2\\SK1", "K1\\SK1\\SSK1", "K2", "K3", "K3\\SK1"
        ));
        ArrayList<String> expectation = new ArrayList<>(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K3", "K3\\SK1"));
        assertThat(result.toString(), is(expectation.toString()));
    }

    @Test
    public void whenTreeSetDown() {
        SortTreeSetDepartament dep = new SortTreeSetDepartament();
        TreeSet<String> result = dep.sortDown(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K2\\SK1", "K1\\SK1\\SSK1", "K2", "K3", "K3\\SK1"));
        ArrayList<String> expectation = new ArrayList<>(Arrays.asList("K3", "K3\\SK1", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K1",
                "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"));
        assertThat(result.toString(), is(expectation.toString()));
    }

}
