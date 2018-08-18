package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.08.2018
 */

public class ArrayDuplicate {
    /**
     * мметод удаления дубликатов
     * @param mas - входящий массив
     * @return - массив без дубликатов
     *
     */
    public String[] remove(String[] mas) {
        boolean move = false;
        int count = 0;
        int totalCount = 0;
        String comparedValue;
        String temp;
        int endIndex = mas.length - 1;
        int outIndex = mas.length - 1;
        for (int j = 0; j < outIndex; j++) {
            comparedValue = mas[j];
            for (int i = j; i < endIndex; i++) {
                if (comparedValue.equals(mas[i + 1])) {
                    mas[i + 1] = mas[endIndex];
                    endIndex--;
                    count++;
                    totalCount++;
                    move = true;
                } else {
                    move = false;
                }
            }
            if (move) {
                j = j - 1;
                outIndex = outIndex - count;
                count = 0;
            }
        }
        return (Arrays.copyOf(mas, mas.length - totalCount));

        //второй вариант
        /*
         int unique = array.length;
    for (int out = 0; out < unique; out++) {
        for (int in = out + 1; in < unique; in++) {
            if (array[out].equals(array[in])) {
                array[in] = array[unique - 1];
                in--;
                unique--;
            }
        }
    }
    return Arrays.copyOf(array, unique);
         */
    }
}
