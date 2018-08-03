package ru.job4j.max;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 03.08.2018
 */

public class Max {
    /**
     *
     * @param a - first number.
     * @param b - second number.
     * @return - the result of comparing two numbers.
     */
    public String summation(int a, int b) {
        String result;
        if (a > b) {
            result = "Первое число " + a + " больше чем второе число " + b;

        } else {
            result = "Второе число " + b + " больше чем первое " + a;
        }
        return result;
    }
}
