package ru.job4j.chess.figures.white;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 23.09.2018
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (source.y != dest.y + 1 || source.x != dest.x) {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры " + getClass().getSimpleName());
        }
        steps = new Cell[]{dest};
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
