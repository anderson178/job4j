package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;


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
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];

        int deltaX = 2;
        int deltaY = 2;
        //если фигуре так можно ходить (не выходя за преелы массива) то записываем новое место назначения
        for (int delts = 0; delts < 7; delts++ ) {
            if ((source.y == dest.y + delts && source.x == dest.x - delts)
                    || (source.y == dest.y + delts && source.x == dest.x + delts)
                    || (source.y == dest.y - delts && source.x == dest.x - delts)
                    || (source.y == dest.y - delts && source.x == dest.x + delts)
                    ) {
                steps = new Cell[]{dest};
                break;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}