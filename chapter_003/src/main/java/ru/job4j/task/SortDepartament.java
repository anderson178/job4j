package ru.job4j.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 27.11.2018
 */

public class SortDepartament {

    /**
     * Метод отсекает последний департамент в строке
     *
     * @param line - массив подразделений одной строки
     * @return - строка без последнего подразделения
     */
    private String minusDep(String[] line) {
        StringBuilder rst = new StringBuilder();
        if (line.length > 1) {
            for (int j = 0; j < line.length - 1; j++) {
                if (j != line.length - 2) {
                    rst.append(line[j]);
                    rst.append("\\");
                } else {
                    rst.append(line[j]);
                }
            }
        }
        return rst.toString();
    }

    /**
     * Метод сравнения подразделений
     *
     * @param line    - искомое подразделение
     * @param depList - массив подразделений одной строки
     * @return - если совпадений не найдено то true иначе false
     */
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

    /**
     * Метод разделения входного списка структур подразделений на список массивов каждого из подразделений
     *
     * @param depart - структура подразделений
     * @return - список массивов по каждой из структур
     */
    private List<String[]> splitDep(List<String> depart) {
        List<String[]> list = new ArrayList<>();
        for (String dep : depart) {
            list.add(dep.split("\\\\"));
        }
        return list;
    }

    /**
     * Метод вставки пропущенного верхнего уровня подразделения
     *
     * @param depart - структура подразделений
     */
    private void insertDep(List<String> depart) {
        boolean check = false;
        do {
            List<String[]> listDep = splitDep(depart);
            check = false;
            for (String[] depMas : listDep) {
                String temp = minusDep(depMas);
                if (compareDep(temp, depart) && !temp.equals("")) {
                    depart.add(temp);
                    check = true;
                }
            }
        } while (check);
    }

    /**
     * сортивка списка подразделений по убыванию
     *
     * @param departament
     */
    public void sortDown(List<String> departament) {
        this.insertDep(departament);
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

    /**
     * сортивка списка подразделений по возрастанию
     *
     * @param departament
     */
    public void sortUp(List<String> departament) {
        this.insertDep(departament);
        departament.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }
}
