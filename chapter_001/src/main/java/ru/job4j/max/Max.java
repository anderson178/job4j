package ru.job4j.max;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 05.08.2018
 */

public class Max {
    // результат содержащий максимальное число из двух
    int result;

    /**
     *
     * @param a - first number.
     * @param b - second number.
     * @return - the result of comparing two numbers.
     */
    public int summation(int a, int b) {
       result = (a > b) ? a : b;
        return result;
    }

    /**
     * метод получения максимального числа из трех.
     * @param first - первое число
     * @param second - второе число
     * @param third - третье число
     * @return - максимальное число
     */
    public int max(int first, int second, int third) {
        return (this.summation(third, (this.summation(first, second))));

    }
}
