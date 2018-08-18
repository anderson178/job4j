package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.08.2018
 */

public class Check {
    /**
     * метод проверяет, что все элементы в массиве являются true или false.
     * @param mas - входящий массив состоящий из true и false.
     * @return - возвращает true если все элементы массива равны одному состоянию иначе вернет false.
     */
    public boolean mono(boolean[] mas) {
        boolean result = true;
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] != mas[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
