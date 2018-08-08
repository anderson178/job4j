package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.08.2018
 */

public class Square {
    /**
     * метод возвдение элементов массива в квадрат
     * @param bound - количество чисел возведенных в степень
     * @return - массив с возведенными числавми в квадрат
     */
    public int[] calculate(int bound) {
        int[] mas = new int[bound];
        int countBound = 0;
        for (int i = 0; i < mas.length; i++) {
           countBound++;
           mas[i] = countBound;
           mas[i] = mas[i] * mas[i];
        }
        return mas;
    }
}
