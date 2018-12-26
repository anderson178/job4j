package ru.job4j.task;
import org.junit.Test;
import ru.job4j.task.dmitry.SortDepartmentDmitry;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortDepartmentDmitryTest {
    @Test
    public void sort() throws Exception {
        String[] depart = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K1",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };
        String[] expected = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };

        SortDepartmentDmitry sortdep = new SortDepartmentDmitry();
        String[] result = sortdep.sort(depart);
        assertThat(result, is(expected));
    }
    @Test
    public void reverseSort() throws Exception {
        String[] depart = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K1",
                "K2\\SK1",
        };
        String[] expected = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        SortDepartmentDmitry sortdepreverse = new SortDepartmentDmitry();
        String[] result = sortdepreverse.reverseSort(depart);
        assertThat(result, is(expected));
    }
}
