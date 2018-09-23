package ru.job4j.chess.figures.black;

import ru.job4j.chess.exceptionChess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
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
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int wayY = Math.abs(source.y - dest.y);
        int wayX = Math.abs(source.x - dest.x);
        //если фигуре так можно ходить то записываем новое место назначения
        if ((wayY == 2 && wayX == 1) || (wayX == 2 && wayY == 1)) {
            steps = new Cell[] {dest};
        } else {
            throw new ImpossibleMoveException("Нарушение логики хода коня");
        }
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
