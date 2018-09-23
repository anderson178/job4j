package ru.job4j.chess.figures.black;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 23.09.2018
 */
public class PawnBlack implements Figure {
    private final Cell position;


    public PawnBlack(final Cell position) {
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
        return new PawnBlack(dest);
    }
}
