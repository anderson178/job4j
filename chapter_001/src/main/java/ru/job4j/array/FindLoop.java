package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.08.2018
 */

public class FindLoop {

    /**
     * метод поиска мндекса искомого элемента в массивею.
     * @param mas - заданный массив.
     * @param element - искомый элемент.
     * @return - возвращает индекс искомого элемента.
     */
    public int indexOf(int[] mas, int element) {
        int result = -1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == element) {
                result = i;
                break;
            }
        }
        return result;
    }
}
