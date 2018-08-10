package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.08.2018
 */

public class MatrixCheck2 {

    /**
     * метод проверки диагоналей на одинаковые значения.
     * @param mas - входящий массив.
     * @return если диагонали свопадают то вернет true иначе false.
     * первое условие проверяет прямую диагональ а второе обратную диагональ
     */
    public boolean mono2(boolean[][] mas) {
        boolean result = true;
        int countEnd = mas.length - 1;
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i][i] != mas[i + 1][i + 1]) {
                result = false;
                break;
            }
            if (mas[i][countEnd] != mas[i + 1][countEnd - 1]) {
                result = false;
                break;
            }
            countEnd--;
        }
        return result;
    }
}
