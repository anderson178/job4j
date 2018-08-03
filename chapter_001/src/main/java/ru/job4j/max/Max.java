package ru.job4j.max;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 03.08.2018
 */

public class Max {
    // результат содержащий максимальное число
    int result;

    /**
     *
     * @param a - first number.
     * @param b - second number.
     * @return - the result of comparing two numbers.
     */
    public int summation(int a, int b) {
       result = (a>b) ? a:b;
        return result;
    }
}
