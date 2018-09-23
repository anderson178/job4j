package ru.job4j.chess.figures.black;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 23.09.2018
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        int wayY = Math.abs(source.y - dest.y);
        int wayX = Math.abs(source.x - dest.x);
        if ((wayY != 2 || wayX != 1) && (wayX != 2 || wayY != 1)) {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры " + getClass().getSimpleName());
        }
        steps = new Cell[] {dest};
        return steps;
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

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
