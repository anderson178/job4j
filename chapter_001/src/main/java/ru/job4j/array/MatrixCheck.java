package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.08.2018
 */

public class MatrixCheck {

    /**
     * метод проверки диагоналей на одинаковые значения.
     *
     * @param mas - входящий массив.
     * @return если диагонали свопадают то вернет true иначе false.
     * Первый цикл обрабатывает первую диагональ.
     * Второй цикл обрабатывает обратную диагональ.
     */
    public boolean mono(boolean[][] mas) {
        boolean diagonalInverse = true, diagonal = true;
        for (int i = 0, j = mas.length - 1; i < mas.length - 1 && (diagonal || diagonalInverse); i++, j--) {
            if (mas[i][i] != mas[i + 1][i + 1] && diagonal) {
                diagonal = false;
            }
            if (mas[i][j] != mas[i + 1][j - 1] && diagonalInverse) {
                diagonalInverse = false;
            }
        }
        return diagonal || diagonalInverse;
    }
}
