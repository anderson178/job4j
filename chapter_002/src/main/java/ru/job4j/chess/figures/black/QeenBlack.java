package ru.job4j.chess.figures.black;

import ru.job4j.chess.exceptionChess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figure) {
        Cell[] steps = new Cell[Math.abs(source.y - dest.y)];
        int wayX = source.x - dest.y;
        int wayY = source.y - dest.y;
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        int numberDest = dest.ordinal();
        //проверяем может ли фигура так в принципе ходить
        if (deltaX == deltaY || source.x == dest.x || source.y == dest.y) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}