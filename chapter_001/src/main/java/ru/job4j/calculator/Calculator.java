package ru.job4j.calculator;
/**
 *clas Calculator
 *@author Denis Mironenko
 *@since 31.07.2018
 *@version 1.0
 */

public class Calculator {
    /*
     * @param result переменная для хранения результата
     */
    private double result;
    /*
     *метод для сложения двух чисел.
     */
    public void add(double first, double second){
        this.result=first+second;
    }
    /*
     *метод для деления двух чисел.
     */
    public void div(double first, double second){
        this.result=first/second;
    }
    /*
     *метод для вычитания одного числа из другого.
     */
    public void subtract(double first, double second){
        this.result=first-second;
    }
    /*
     *метод для умножения двух чисел.
     */
    public void multiple(double first, double second){
        this.result=first*second;
    }
    /*
     *метод возвращающий результат работы методов калькулятора.
     */
    public double getResult() {
        return this.result;
    }

}
