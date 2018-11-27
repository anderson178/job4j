package ru.job4j.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortDepartament {

    public void sortUp(List<String> departament) {

        departament.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }

    public void missedDep(List<String> departament) {
        Boolean rt = false;
        for (int i = 0; i < departament.size(); i++) {
            String[] masLine = departament.get(i).split("\\\\");
            for (int j = 0; j < departament.size(); j++) {
                if (masLine.length > 1 && masLine[0].equals(departament.get(j))) {
                    rt = true;
                   break;
                }
            }
            if (!rt) {
                departament.add(masLine[0]);
            }

        }
    }

    private String minusDep(String[] line) {
        StringBuilder rst= new StringBuilder();
        if (line.length > 1) {
            for (int j = 0; j < line.length - 1; j++) {
                if (j != line.length -2) {
                    rst.append(line[j]);
                    rst.append("\\");
                } else {
                    rst.append(line[j]);
                }
            }
        }
        return rst.toString();
    }

    private boolean compareDep(String line, List<String> depList) {
        boolean rst = false;
        for (String dep : depList) {
            if (line.equals(dep)) {
                rst = false;
                break;
            } else {
                rst = true;
            }
        }
        return rst;
    }

    private List<String[]> splitDep(List<String> depart) {
        List<String[]> list = new ArrayList<>();
        for (String dep : depart) {
            list.add(dep.split("\\\\"));
        }
        return list;
    }

    public void insertDep(List<String> depart) {
        boolean check = false;
        do {
            List<String[]> list = splitDep(depart);
            check = false;
            for (int i = 0; i < list.size(); i++) { // проходим по листу
                String temp = minusDep(list.get(i));
                if (compareDep(temp, depart) && !temp.equals("")) {
                    depart.add(temp);
                    check = true;
                }
            }
        } while (check);


        //list.add(depart.get(0).split("\\\\"));
        int p=0;


    }

    public void sortDown(List<String> departament) {
        this.missedDep(departament);
        departament.sort(new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                String[] line1 = left.split("\\\\");
                String[] line2 = right.split("\\\\");
                int rst = 0;
                int size = line1.length < line2.length ? line1.length : line2.length;
                for (int i = 0; i < size; i++) {
                    if (!line1[i].equals(line2[i])) {
                        rst = line2[i].compareTo(line1[i]);
                        break;
                    }
                }
                if (rst == 0 && line1.length < line2.length) {
                    rst = -1;
                } else if (rst == 0 && line1.length > line2.length) {
                    rst = 1;
                }
                return rst;
            }
        });
    }
}
