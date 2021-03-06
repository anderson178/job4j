package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 27.09.2018
 */

public class Logic3T {
    private final Figure3T[][] table;
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     *Проверяет выиграли ли крестики
     * @return - true если хотя бы один из рядов заполнен, иначе false
     */
    public boolean isWinnerX() {
        boolean rst = false;
        for (int i = 0; i < this.table.length; i++) {
            rst = this.fillBy(Figure3T::hasMarkX, 0, i, 1, 0)
                    || this.fillBy(Figure3T::hasMarkX, i, 0, 0, 1);
            if (rst) {
                break;
            }
        }

        if (!rst) {
            if (this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                    || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1)) {
                rst = true;
            }
        }
        return rst;
    }

    /**
     *Проверяет выиграли ли нолики
     * @return - true если хотя бы один из рядов заполнен, иначе false
     */
    public boolean isWinnerO() {
        boolean rst = false;
        for (int i = 0; i < this.table.length; i++) {
            rst = this.fillBy(Figure3T::hasMarkO, 0, i, 1, 0)
                    || this.fillBy(Figure3T::hasMarkO, i, 0, 0, 1);
            if (rst) {
                break;
            }
        }

        if (!rst) {
            if (this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                    || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1)) {
                rst = true;
            }
        }
        return rst;
    }

    /**
     * Проверяет все лип поля заполнены
     *
     * @return - true если есть пустые поля, false - если все поля заполнены
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMarkO()) {
                        result = true;
                        break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}
