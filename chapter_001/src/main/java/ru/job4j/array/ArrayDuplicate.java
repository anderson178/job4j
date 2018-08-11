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
        //ключ для возврата к начальному поисковому элементу если было перемещение после первого прохода
        boolean move = false;
        //кол-во перемещений во внутреннем цикле
        int count = 0;
        // общее кол-во перемещений
        int totalCount = 0;
        //сравниваемый элемент
        String comparedValue;
        //временная переменная для перетасовки элментов
        String temp;
        //границы внутреннего цикла
        int endIndex = mas.length - 1;
        //границы внешнего цикла
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
            //условие для возврата к начальному проверяемому элементу массива
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
