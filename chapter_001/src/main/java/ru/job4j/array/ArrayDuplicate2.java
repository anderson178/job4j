package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.08.2018
 */

public class ArrayDuplicate2 {
    /**
     * мметод перемещает дубликаты в конец массива
     * @param inMas - входящий массив
     * @return - отсортированный массив
     */
    public int sort(String[] inMas) {
        String comparedValue;
        String temp;
        int count = 0;
        int endIndex = inMas.length - 1;
        for (int j = 0; j < inMas.length - 1; j++) {
            comparedValue = inMas[j];
            for (int i = j; i < endIndex; i++) {
                if (comparedValue.equals(inMas[i + 1])) {
                    temp = inMas[i + 1];
                    inMas[i + 1] = inMas[endIndex];
                    inMas[endIndex] = temp;
                    endIndex--;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * метод записывает в ноый массив значения из старого но без дубликатов
     * @param mas - входящий массив
     * @return - массив без дубликатов
     */
    public String[] remove(String[] mas) {
        int count = sort(mas);
        String[] tempMas = Arrays.copyOf(mas, mas.length - count);
        return tempMas;

    }
}
