package ru.job4j.condition;
/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 03.08.2018
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * @param a - координаты точки a
     * @param b - координаты точки b
     * @param c - координаты точки c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * метод для расчета полупериметра
     * @param ab - расстояние от точки a до точки b
     * @param bc - расстояние от точки b до точки c
     * @param ca - расстояние от точки c до точки a
     * @return - результат расчета
     */
    public double poluperimetr(double ab, double bc, double ca) {
        return ((ab + bc + ca) / 2);
    }

    /**
     * проверка на возможность построения треугольника исходя из заданных значений
     * @param a - длина стороны a
     * @param b - длина стороны b
     * @param c - длина стороны c
     * @return - возвращает либо true либо false
     */
    public boolean existtriangle(double a, double b, double c) {
       return ((b + c > a) && (a + c > b) && (a + b > c));
    }

    /**
     * метод расчета площади треугольника
     * @return - вернет -1 в случае если треугольник нельзя построить иначе вернет расчет
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(b);
        double bc = this.b.distanceTo(c);
        double ca = this.c.distanceTo(a);
        double p = this.poluperimetr(ab, bc, ca);
        if (this.existtriangle(ab, bc, ca)) {
           rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
        }
        return rsl;
    }

}
