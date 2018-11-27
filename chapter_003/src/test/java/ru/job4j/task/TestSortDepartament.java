package ru.job4j.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 27.11.2018
 */


public class TestSortDepartament {
    private String convertToString(ArrayList<String> list) {
        String ln = System.lineSeparator();
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                rst.append(list.get(i));
                rst.append(ln);
            } else {
                rst.append(list.get(i));
            }
        }
        return rst.toString();
    }

    @Test
    public void whenSortDownWithOutDepartamaents() {
        String ln = System.lineSeparator();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1"));
        SortDepartament st = new SortDepartament();
        st.sortDown(list);
        assertThat(convertToString(list), is(new StringBuffer()
                .append("K2")
                .append(ln)
                .append("K2\\SK1")
                .append(ln)
                .append("K2\\SK1\\SSK1")
                .append(ln)
                .append("K1")
                .append(ln)
                .append("K1\\SK2")
                .append(ln)
                .append("K1\\SK1")
                .append(ln)
                .append("K1\\SK1\\SSK2")
                .toString()
        ));
    }

    @Test
    public void whenSortUpWithOutDepartamaents() {
        String ln = System.lineSeparator();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1"));
        SortDepartament st = new SortDepartament();
        st.sortUp(list);
        assertThat(convertToString(list), is(new StringBuffer()
                .append("K1")
                .append(ln)
                .append("K1\\SK1")
                .append(ln)
                .append("K1\\SK1\\SSK2")
                .append(ln)
                .append("K1\\SK2")
                .append(ln)
                .append("K2")
                .append(ln)
                .append("K2\\SK1")
                .append(ln)
                .append("K2\\SK1\\SSK1")
                .toString()
        ));
    }

    @Test
    public void whenSortDownDepartaments() {
        String ln = System.lineSeparator();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K2\\SK1", "K1\\SK1\\SSK1", "K2", "K3", "K3\\SK1"
        ));
        SortDepartament st = new SortDepartament();
        st.sortDown(list);
        assertThat(convertToString(list), is(new StringBuffer()
                .append("K3")
                .append(ln)
                .append("K3\\SK1")
                .append(ln)
                .append("K2")
                .append(ln)
                .append("K2\\SK1")
                .append(ln)
                .append("K2\\SK1\\SSK1")
                .append(ln)
                .append("K1")
                .append(ln)
                .append("K1\\SK2")
                .append(ln)
                .append("K1\\SK1")
                .append(ln)
                .append("K1\\SK1\\SSK2")
                .append(ln)
                .append("K1\\SK1\\SSK1")
                .toString()
        ));
    }

    @Test
    public void whenSortUpDepartaments() {
        String ln = System.lineSeparator();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K2\\SK1", "K1\\SK1\\SSK1", "K2", "K3", "K3\\SK1"
        ));
        SortDepartament st = new SortDepartament();
        st.sortUp(list);
        assertThat(convertToString(list), is(new StringBuffer()
                .append("K1")
                .append(ln)
                .append("K1\\SK1")
                .append(ln)
                .append("K1\\SK1\\SSK1")
                .append(ln)
                .append("K1\\SK1\\SSK2")
                .append(ln)
                .append("K1\\SK2")
                .append(ln)
                .append("K2")
                .append(ln)
                .append("K2\\SK1")
                .append(ln)
                .append("K2\\SK1\\SSK1")
                .append(ln)
                .append("K3")
                .append(ln)
                .append("K3\\SK1")
                .toString()
        ));
    }

}
