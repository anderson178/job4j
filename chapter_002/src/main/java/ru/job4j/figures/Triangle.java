package ru.job4j.figures;

/**
 * Метод-тесты для операций в трекере
 * @author Денис Мироненко
 * @version $Id$
 * @since 03.09.2018
 */

public class Triangle implements Shape {
    /**
     * метод прорисовки треугольника в псевдографике
     * @param size - высота треугольника
     * @return
     */
    public String draw(int size) {
        int height = size;
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            if (row < height - 1) {
                screen.append(System.lineSeparator());
            }
        }
        return screen.toString();
        //return figure;
    }
}
