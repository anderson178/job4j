package ru.job4j.task.dmitry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDepartmentDmitry {

        public String[] sort(String[] depart) {
            Arrays.sort(depart);
            return depart;
        }

        public String[] reverseSort(String[] depart) {
            List<String> list = new ArrayList<String>(Arrays.asList(depart));
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int result = 0;
                    String[] mas1 = o1.split("\\\\");
                    String[] mas2 = o2.split("\\\\");
                    int minimal = Math.min(mas1.length, mas2.length);
                    for (int i = 0; i < minimal; i++) {
                        if (!mas1[i].equals(mas2[i])) {
                            result = mas2[i].compareTo(mas1[i]);
                            break;
                        }
                    }
                    if (result == 0) {
                        if (mas1.length > mas2.length) {
                            result = 1;
                        } else {
                            result = -1;
                        }
                    }
                    return result;
                }
            });
            return list.toArray(new String[list.size()]);
        }
    }

