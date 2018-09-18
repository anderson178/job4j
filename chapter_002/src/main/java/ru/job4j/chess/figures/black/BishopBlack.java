package ru.job4j.chess.figures.black;

import ru.job4j.chess.Chess;
import ru.job4j.chess.exceptionChess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.exceptionChess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.09.2018
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
        int wayX = source.x - dest.y;
        int wayY = source.y - dest.y;
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        int numberDest = dest.ordinal();
        //проверяем может ли фигура так в принципе ходить
        if (source.x == dest.y && source.y == dest.y && deltaX != deltaY) {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры");
        } else {
            int stepX = wayX >= 0 ? 1 : -1;
            int stepY = wayY >= 0 ? 1 : -1;


        }


        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}