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
    public Cell[] way(Cell source, Cell dest) {
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        int size = deltaY >= deltaX ? deltaY : deltaX;
        Cell[] steps = new Cell[size];
        if (deltaX != deltaY && source.x != dest.x && source.y != dest.y) {
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
        return new QeenBlack(dest);
    }
}