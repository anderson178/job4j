package ru.job4j.task;

import java.util.*;

public class SortTreeSetDepartament {

    private List<String[]> splitDep(List<String> depart) {
        List<String[]> list = new ArrayList<>();
        for (String dep : depart) {
            list.add(dep.split("\\\\"));
        }
        return list;
    }

    private void addDep(String[] line, TreeSet<String> tree) {
        StringBuilder rst = new StringBuilder();
        if (line.length > 1) {
            for (int j = 0; j < line.length; j++) {
                if (j != line.length - 1) {
                    rst.append(line[j]);
                    tree.add(rst.toString());
                    rst.append("\\");
                } else  {
                    rst.append(line[j]);
                    tree.add(rst.toString());
                }
            }
        } else {
            tree.add(line[0]);
        }
        //return rst.toString();
    }

    public void insertDep(List<String> listDep) {
        TreeSet<String> treeDep = new TreeSet<>(new SortComparator());

        for (String dep : listDep) {
            String[] temp = dep.split("\\\\");
            addDep(temp, treeDep);
            int p =0;
        }
        //treeDep.comparator(new SortComparator());
        int p =0;
    }
}
