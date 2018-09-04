package ru.job4j.figures;

/**
 * Метод-тесты для операций в трекере
 * @author Денис Мироненко
 * @version $Id$
 * @since 04.09.2018
 */

public class Square implements Shape {
    /**
     * метод прорисовки квадрата в псевдографике
     * @param size
     * @return
     */
    public String draw(int size) {
        StringBuilder screen = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                screen.append("# ");
            }
            if (i < size - 1) {
                screen.append(System.lineSeparator());
            }
        }
        return screen.toString();
    }
}
