package ru.job4j.chess.figures.move;

import ru.job4j.chess.Chess;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;

public abstract class Bishop implements Figure {
    public  final Cell source;
    public  final Cell dest;
    /*@Override
    public Cell position() {
        return null;
    }*/

    public Bishop(Cell source, Cell dest) {
        this.source = source;
        this.dest = dest;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figure) {
        Cell[] steps = new Cell[0];
        Chess chess = new Chess();
        //если фигуре так можно ходить (не выходя за преелы массива) то записываем новое место назначения
        for (int delta = 0; delta < chess.getSize() - 1; delta++) {
            if ((source.y == dest.y + delta && source.x == dest.x - delta)
                    || (source.y == dest.y + delta && source.x == dest.x + delta)
                    || (source.y == dest.y - delta && source.x == dest.x - delta)
                    || (source.y == dest.y - delta && source.x == dest.x + delta)
                    ) {
                steps = new Cell[]{dest};
                break;
            } else {
                System.out.println("нарушение логики хода слона");
            }
        }
        return steps;
    }

    /*@Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }*/
}
