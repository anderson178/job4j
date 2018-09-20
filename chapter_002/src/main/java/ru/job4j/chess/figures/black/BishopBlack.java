package ru.job4j.chess.figures.black;


import ru.job4j.chess.exceptionChess.ImpossibleMoveException;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 20.09.2018
 */

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.09.2018
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figure) throws ImpossibleMoveException {
        Cell[] steps = new Cell[Math.abs(source.y - dest.y)];
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        int x1 = 1;
        int x2 = - 1;
        int y1 = 1;
        int y2 = - 1;
        //проверяем может ли фигура так в принципе ходить
        if (deltaY == deltaX) {
            for (int i = 0; i < steps.length; i++) {
                int stepX = source.x >= dest.x ? x2-- : x1++;
                int stepY = source.y >= dest.y ? y2-- : y1++;
                Cell temp = this.findPosition(source.x + stepX, source.y + stepY);
                steps[i] = temp;
           }
        } else {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
    public Cell findPosition( int x, int y) {
        Cell[] temp = Cell.values();
        Cell result = null;
        for (Cell cell : temp) {
            if (x == cell.x && y == cell.y) {
                result = cell;
                break;
            }
        }
        return result;
    }
}