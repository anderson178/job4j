package ru.job4j.my;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.08.2018
 */

public class NumberPolindrom {
    /**
     * метод проверяет является ли массив полиндромом
     * @param mas - входящий массив
     * @return - true or false
     */
    public boolean checkPol(int[] mas) {
        int end = mas.length - 1;
        boolean result = false;
        for (int i = 0; i < Math.floor(mas.length / 2); i++) {
            if (mas[i] == mas[end]) {
                result = true;
            } else {
                result = false;
                break;
            }
            end--;
        }
        return result;
    }
}
