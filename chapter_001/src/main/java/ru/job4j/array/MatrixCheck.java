package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.08.2018
 */

public class MatrixCheck {

    /**
     * метод проверки диагоналей на одинаковые значения.
     * @param mas - входящий массив.
     * @return если диагонали свопадают то вернет true иначе false.
     * Первый цикл обрабатывает первую диагональ.
     * Второй цикл обрабатывает обратную диагональ.
     */
    public boolean mono(boolean[][] mas) {
        boolean temp = mas[0][0];
        boolean result = true;
        int countEnd = mas.length - 1;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i][i] != temp) {
                result = false;
                break;
            }
        }
        for (int i = 0; i < mas.length; i++) {
            if (mas[i][countEnd] != temp) {
                result = false;
                break;
            }
            countEnd--;
        }
        int p=0;
        return result;
    }
}
