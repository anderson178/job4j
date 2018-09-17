package ru.job4j.chess.figures.black;

import ru.job4j.chess.Chess;
import ru.job4j.chess.ExceptionChess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
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
    public Cell[] way(Cell source, Cell dest, Figure[] figure) {
        Cell[] steps = new Cell[Math.abs(source.y - dest.y)];
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        int numberDest = dest.ordinal();
        //проверяем может ли фигура так в принципе ходить
        if ((source.y == dest.y + deltaY && source.x == dest.x - deltaX)
                || (source.y == dest.y + deltaY && source.x == dest.x + deltaX)
                || (source.y == dest.y - deltaY && source.x == dest.x - deltaX)
                || (source.y == dest.y - deltaY && source.x == dest.x + deltaX)
                ) {
            for (int i = 0; i < steps.length; i++) {
                //ищем путь диагонали.
                if (dest.y < source.y && dest.x < source.x) { //Путь в верх на лево
                    steps[i] = Cell.values()[numberDest];
                    numberDest = numberDest + new Chess().getSize() + 1;
                } else if (dest.y < source.y && dest.x > source.x) { //Путь в верх на право
                    steps[i] = Cell.values()[numberDest];
                    numberDest = numberDest - new Chess().getSize() + 1;
                } else if (dest.y > source.y && dest.x > source.x) { //Путь вниз направо
                    steps[i] = Cell.values()[numberDest];
                    numberDest = numberDest - new Chess().getSize() - 1;
                } else { //Путь вниз на лево
                    steps[i] = Cell.values()[numberDest];
                    numberDest = numberDest + new Chess().getSize() - 1;
                }
            }
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}