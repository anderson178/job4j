package ru.job4j.chess.figures.black;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 23.09.2018
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int size = source.y == dest.y ? Math.abs(source.x - dest.x) : Math.abs(source.y - dest.y);
        Cell[] steps = new Cell[size];
        if (source.x != dest.x && source.y != dest.y) {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры " + getClass().getSimpleName());
        }
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int stepX = source.x;
        int stepY = source.y;
        for (int i = 0; i < steps.length; i++) {
            stepX += deltaX;
            stepY += deltaY;
            steps[i] = this.findPosition(stepX, stepY);
        }
        return steps;
    }

    /**
     * поиск фигуры по координатам
     *
     * @param x - координата X
     * @param y - координата Y
     * @return - возвращает фигуру с координатами X  и Y иначе null
     */
    private Cell findPosition(int x, int y) {
        return Arrays.stream(Cell.values()).filter(value -> x == value.x && y == value.y).findFirst().orElse(null);
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}