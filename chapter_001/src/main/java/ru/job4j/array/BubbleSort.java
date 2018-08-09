package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.08.2018
 */

public class BubbleSort {
    /**
     * метод сортировки массива пузырьком.
     * @param inputArray - входящий неотсортированный массив.
     * @return - отсортированный массив.
     * Внутренний цикл постоянно проходит от начала до конца массива.
     * Вшений цикл работает пока хоть раз в внутреннем цикле была совершена перестановка.
     */
    public int[] bSort(int[] inputArray) {
        int temp;
        int stap = 1;
        while (stap != inputArray.length) {
            stap = 1;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                } else {
                    stap++;
                }
            }
        }
        return inputArray;
    }

}
