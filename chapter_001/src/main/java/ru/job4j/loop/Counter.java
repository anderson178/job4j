package ru.job4j.loop;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 06.08.2018
 */

public class Counter {
    /**
     *
     * @param first - начальный параметр
     * @param second - конечный параметр
     * @return - сумма всех четных чисел от начального до конеченого параметров
     */
    public int add(int first, int second) {
        int temp = 0;
        //int i = first;
        for (int i = first; i <= second; i++) {
            if (i % 2 == 0) {
                temp = temp + i;
            }
        }
        return temp;
    }
}
