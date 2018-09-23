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
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[Math.abs(source.y - dest.y)];
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        if (deltaY != deltaX) {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры");
        }
        deltaX = Integer.compare(dest.x, source.x);
        deltaY = Integer.compare(dest.y, source.y);
        int stepX = source.x;
        int stepY = source.y;
        for (int i = 0; i < steps.length; i++) {
            stepX += deltaX;
            stepY += deltaY;
            steps[i] = this.findPosition(stepX, stepY);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private Cell findPosition(int x, int y) {
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