package ru.job4j.max;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 03.08.2018
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
        int temp = this.summation(first, second);
        temp = this.summation(temp, third);
        return temp;

    }
}
