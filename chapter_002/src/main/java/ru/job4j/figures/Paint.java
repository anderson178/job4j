package ru.job4j.figures;

/**
 * Метод-тесты для операций в трекере
 * @author Денис Мироненко
 * @version $Id$
 * @since 03.09.2018
 */

public class Paint {
    /**
     * метод вывода на печать фигуры в псевдографике
     * @param shape - фигура
     * @param size - размер фигуры
     */
    public void draw(Shape shape, int size) {
        System.out.println(shape.draw(size));
    }

    public static void main(String[] args) {
        int size = 4;
        Shape shape = new Triangle();
        Paint paint = new Paint();
        paint.draw(shape, size);
        shape = new Square();
        paint.draw(shape, size);
    }
}
