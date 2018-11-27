package ru.job4j.task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSortDepartament {
    @Test
    public void WhenSortUp() {
        ArrayList<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK2");
        //list.add("K2\\SK1\\SSK2");
        list.add("K2\\SK1\\SSK1");
        //list.add("K1");
        //list.add("K2\\SK1");
       // list.add("K1\\SK1\\SSK1");
        //list.add("K2");
        //list.add("K3");
        //list.add("K3\\SK1");
        SortDepartament st = new SortDepartament();
       // st.sortUp(list);
        st.insertDep(list);

        st.sortDown(list);
        int o =0;
       // List<String> listSortDown = new ArrayList<>(st.sortDown(list));
    }

}
