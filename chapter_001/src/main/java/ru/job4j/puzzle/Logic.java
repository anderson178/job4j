package ru.job4j.puzzle;

import ru.job4j.puzzle.figures.Cell;
import ru.job4j.puzzle.figures.Figure;

/**
 * //TODO add comments.
 *
 * @author Мироненко Денис
 * @version $Id$
 * @since 25.12.2018
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    private boolean check(int startX, int startY, int deltaX, int deltaY) {
        boolean result = false;
        int[][] table = this.convert();
        for (int i = 0; i < table.length; i++) {
            if (table[startX][startY] != 1) {
                result = false;
                break;
            } else {
                result = true;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return result;
    }

    public boolean isWin() {
        boolean result = false;
        int[][] table = this.convert();
        for (int i = 0; i < table.length; i++) {
            result = this.check(0, i, 1, 0)
                    || this.check(i, 0, 0, 1);
            if (result) {
                break;
            }
        }
        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
