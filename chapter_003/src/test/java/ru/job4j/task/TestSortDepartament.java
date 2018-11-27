package ru.job4j.task;
import javafx.scene.control.Separator;
import org.junit.Test;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSortDepartament {
    private String convertToString(ArrayList<String> list) {
        String ln = System.lineSeparator();
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() -1) {
                rst.append(list.get(i));
                rst.append(ln);
            } else {
                rst.append(list.get(i));
            }
        }
        return rst.toString();
    }

    @Test
    public void WhenSortDownWithOutDepartamaents() {
        String ln = System.lineSeparator();
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

}
