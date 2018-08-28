package ru.job4j.tictactoe;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 19.08.2018
 */

public class Logic3T {
    private final Figure3T[][] table;


    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }
   /**
     * Проверяет выиграли ли крестики
     * Первый цикл проверяет горизонталь, второй - вертикаль, третий - диагональ, четвертый - обратная диагональ
     * @return - true если хотя бы один ряд заполнен иначе false
     */
    public boolean isWinnerX() {
      boolean result = false;
      int countEnd = this.table.length - 1;
      int countCheck = 0;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkX()) {
                    countCheck++;
                    if (countCheck == this.table.length) {
                        result = true;
                        break;
                    }
                } else {
                    j = this.table.length;
                }
            }
            countCheck = 0;
        }
        for (int j = 0; j < this.table.length; j++) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][j].hasMarkX()) {
                    countCheck++;
                    if (countCheck == this.table.length) {
                        result = true;
                        break;
                    }
                } else {
                    i = this.table.length;
                }
            }
            countCheck = 0;
        }
        for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][i].hasMarkX()) {
                    countCheck++;
                    if (countCheck == this.table.length) {
                        result = true;
                        break;
                    }
                } else {
                    i = this.table.length;
                }
            countCheck = 0;
        }
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i][countEnd].hasMarkX()) {
                countCheck++;
                if (countCheck == this.table.length) {
                    result = true;
                    break;
                }
            } else {
                i = this.table.length;
            }
            countEnd--;
        }

       return result;
    }
    /**
     * Проверяет выиграли ли нолики
     * Первый цикл проверяет горизонталь, второй - вертикаль, третий - диагональ, четвертый - обратная диагональ
     * @return - true если хотя бы один ряд заполнен иначе false
     */
    public boolean isWinnerO() {
        boolean result = false;
        int countEnd = this.table.length - 1;
        //проверяем строки
        int countCheck = 0;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkO()) {
                    countCheck++;
                    if (countCheck == this.table.length) {
                        result = true;
                        break;
                    }
                } else {
                    j = this.table.length;
                }
            }
            countCheck = 0;
        }
        //проверяем столбцы
        for (int j = 0; j < this.table.length; j++) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][j].hasMarkO()) {
                    countCheck++;
                    if (countCheck == this.table.length) {
                        result = true;
                        break;
                    }
                } else {
                    i = this.table.length;
                }
            }
            countCheck = 0;
        }

        //прямая диагональ
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i][i].hasMarkO()) {
                countCheck++;
                if (countCheck == this.table.length) {
                    result = true;
                    break;
                }
            } else break;
        }
        countCheck = 0;
        //обратная диагональ
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i][countEnd].hasMarkO()) {
                countCheck++;
                if (countCheck == this.table.length) {
                    result = true;
                    break;
                }
            } else break;
            countEnd--;
        }
        return result;
    }
    /**
     * Проверяет все лип поля заполнены
     * @return - true если есть пустые поля, false - если все поля заполнены
     */
    public boolean hasGap() {
        boolean temp = false;
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMarkO()) {
                    result = true;
                    temp = true;
                    break;
                }
            }
            if (temp) break;
        }
        return result;
    }
}
