package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;


    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
      boolean result = false;
      int countEnd = this.table.length - 1;
        //проверяем строки
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
        //проверяем столбцы
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

        //прямая диагональ
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
        //обратная диагональ
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

    public boolean isWinnerO() {
        boolean result = false;

        return result;

    }

    public boolean hasGap() {
        return true;
    }
}
