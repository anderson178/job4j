package ru.job4j.chess;

import ru.job4j.chess.ExceptionChess.FigureNotFoundException;
import ru.job4j.chess.ExceptionChess.ImpossibleMoveException;
import ru.job4j.chess.ExceptionChess.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.09.2018
 */

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public Figure[] getFigures() {
        return this.figures;
    }

    /**
     * метод перемещения фигуры
     *
     * @param source - начальные координат фигуры
     * @param dest   - целевые координаты фигуры
     * @return - возвращает true если ход возможен, иначе false
     * @throws OccupiedWayException    - исключение если клетка не пустая
     * @throws ImpossibleMoveException - исключение если нарушается логика хождения фигуры
     * @throws FigureNotFoundException - исключение если фигуры не сущетсвует
     */
    public boolean move(Cell source, Cell dest) throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Фигуры не существует");
        } else {
            Cell[] steps = this.figures[index].way(source, dest, this.figures);
            if (!(steps.length > 0)) {
                throw new ImpossibleMoveException("Нарушение логики хода фигуры");
            }
            if (!this.existFigure(steps)) {
                throw new OccupiedWayException("Клетка не пуста");
            } else {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    /**
     * метод проверяет на наличие другой фигуры по пути прохождения текущей фигуры до
     * нового места назначения текущей фигуры.
     *
     * @param steps - массив (дистанция)
     * @return - false если хоть одна клетка будет занята
     */
    private boolean existFigure(Cell[] steps) {
        boolean rst = true;
        for (Figure figure : this.figures) {
            for (Cell step : steps) {
                if (figure.position().equals(step)) {
                    rst = false;
                }
            }
        }
        return rst;
    }

    /**
     * возврат фигур в исходное положение
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * получает индекс фигуры. Показывает какой именно фигурой ты ходишь.
     *
     * @param cell - фигура
     * @return
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}