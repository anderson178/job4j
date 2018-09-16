package ru.job4j.chess.figures.white;

import ru.job4j.chess.Chess;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.09.2018
 */

public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figure) {
        Cell[] steps = new Cell[0];
        Chess chess = new Chess();
        for (int delta = 0; delta < chess.getSize() - 1; delta++) {
            if ((source.y == dest.y + delta && source.x == dest.x - delta)
                    || (source.y == dest.y + delta && source.x == dest.x + delta)
                    || (source.y == dest.y - delta && source.x == dest.x - delta)
                    || (source.y == dest.y - delta && source.x == dest.x + delta)
                    ) {
                steps = new Cell[]{dest};
                break;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}