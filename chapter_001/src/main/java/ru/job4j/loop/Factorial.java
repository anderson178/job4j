package ru.job4j.loop;
/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 06.08.2018
 */
public class Factorial {
    /**
     * метод расчета факториала заданного числа
     * @param n - факториал числа
     * @return - возвращает расчет факториала заданного числа
     */
    public int calculationFactorial(int n) {
       int temp = 1;
           for (int i = n; i > 0; i--) {
               temp = temp * i;
           }
           return temp;
    }
}
