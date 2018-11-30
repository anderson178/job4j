package ru.job4j.task;

import java.util.Comparator;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 30.11.2018
 */

public class SortComparator implements Comparator<String> {
    /**
     * Метод сравнения двух элементов на убывание
     * @param left - первый элемент
     * @param right - второй эелемент
     * @return - результат сравнения
     */
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

}
