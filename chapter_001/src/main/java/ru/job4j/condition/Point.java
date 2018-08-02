package ru.job4j.condition;

import java.nio.channels.Pipe;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 02.08.2018
 */

public class Point {
    //расстояние от предпологаемой точки до оси x
    private int x;
    //расстояние от предпологаемой точки до оси y
    private int y;

    /**
     * Данный конструктор необходим для инициалиизации точек
     * @param x - точки по оси X
     * @param y - точка по оси Y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расчитываем расстояние от точки A до точки B.
     * @param that - коорлинаты точки b
     * @return result - Результат расчета расстояния между точками А и B
     * через this обращаемся к координате точки А проинициализированной в методе main
     */
    public double distanceTo(Point that) {
        double result = Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(2, 3);
        Point b = new Point(6, -5);
        double distance = a.distanceTo(b);
        System.out.println("Расстояние от точки А до точки Б = " + distance);
    }
}
