package ru.job4j.chess.figures.black;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 23.09.2018
 */
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        if (deltaY != 1 && deltaX != 1) {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры " + getClass().getSimpleName());
        }
        steps = new Cell[]{dest};
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}