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
     */
    public String[] remove(String[] mas) {
        String comparedValue;
        String temp;
        int count = 0;
        int endIndex = mas.length - 1;
        for (int j = 0; j < mas.length - 1; j++) {
            comparedValue = mas[j];
            for (int i = j; i < endIndex; i++) {
                if (comparedValue.equals(mas[i + 1])) {
                    temp = mas[i + 1];
                    mas[i + 1] = mas[endIndex];
                    mas[endIndex] = temp;
                    endIndex--;
                    count++;
                }
            }
        }
        String[] tempMas = Arrays.copyOf(mas, mas.length - count);
        return tempMas;

    }
}
