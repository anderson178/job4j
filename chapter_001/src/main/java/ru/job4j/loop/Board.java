package ru.job4j.loop;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 07.08.2018
 */

public class Board {
    /**
     * метод построения шахматной доски в псевдографике по входящим параметрам
     * @param weight - ширина поля
     * @param height - высота поля
     * @return - построенная шахматная доска
     */
    public String paint(int weight, int height) {
        String ln = System.lineSeparator();
        StringBuilder screen = new StringBuilder();
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                screen.append((count % 2 == 0) ? "X" : " ");
                count++;
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
