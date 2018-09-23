package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.figures.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 23.09.2018
 */

public class FiguresTest {
    private Logic logicFigure = new Logic();

    private void fillFigures(Logic logic) {
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new PawnBlack(Cell.B7));
        logic.add(new PawnBlack(Cell.C7));
        logic.add(new PawnBlack(Cell.D7));
        logic.add(new PawnBlack(Cell.E7));
        logic.add(new PawnBlack(Cell.F7));
        logic.add(new PawnBlack(Cell.G7));
        logic.add(new PawnBlack(Cell.H7));
        logic.add(new RookBlack(Cell.A8));
        logic.add(new KnightBlack(Cell.B8));
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new QeenBlack(Cell.D8));
        logic.add(new KingBlack(Cell.E8));
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new KnightBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));
        logic.add(new PawnWhite(Cell.A2));
        logic.add(new PawnWhite(Cell.B2));
        logic.add(new PawnWhite(Cell.C2));
        logic.add(new PawnWhite(Cell.D2));
        logic.add(new PawnWhite(Cell.E2));
        logic.add(new PawnWhite(Cell.F2));
        logic.add(new PawnWhite(Cell.G2));
        logic.add(new PawnWhite(Cell.H2));
        logic.add(new RookWhite(Cell.A1));
        logic.add(new KnightWhite(Cell.B1));
        logic.add(new BishopWhite(Cell.C1));
        logic.add(new QeenWhite(Cell.D1));
        logic.add(new KingWhite(Cell.E1));
        logic.add(new BishopWhite(Cell.F1));
        logic.add(new KnightWhite(Cell.G1));
        logic.add(new RookWhite(Cell.H1));
    }

    @Test
    public void testBishop() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] actual = bishop.way(bishop.position(), Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void testKing() {
        KingBlack king = new KingBlack(Cell.E8);
        Cell[] actual = king.way(king.position(), Cell.F7);
        Cell[] expected = {Cell.F7};
        assertThat(actual, is(expected));
    }

    @Test
    public void testKnight() {
        KnightBlack knight = new KnightBlack(Cell.B8);
        Cell[] actual = knight.way(knight.position(), Cell.C6);
        Cell[] expected = {Cell.C6};
        assertThat(actual, is(expected));
    }

    @Test
    public void testPawn() {
        PawnBlack pawn = new PawnBlack(Cell.F7);
        Cell[] actual = pawn.way(pawn.position(), Cell.F6);
        Cell[] expected = {Cell.F6};
        assertThat(actual, is(expected));
    }

    @Test
    public void testQeenHorizon() {
        QeenBlack qeen = new QeenBlack(Cell.D8);
        Cell[] actual = qeen.way(qeen.position(), Cell.H8);
        Cell[] expected = {Cell.E8, Cell.F8, Cell.G8, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void testQeenDiagonal() {
        QeenBlack qeen = new QeenBlack(Cell.D8);
        Cell[] actual = qeen.way(qeen.position(), Cell.H4);
        Cell[] expected = {Cell.E7, Cell.F6, Cell.G5, Cell.H4};
        assertThat(actual, is(expected));
    }

    @Test
    public void testQeenVertical() {
        QeenBlack qeen = new QeenBlack(Cell.D8);
        Cell[] actual = qeen.way(qeen.position(), Cell.D4);
        Cell[] expected = {Cell.D7, Cell.D6, Cell.D5, Cell.D4};
        assertThat(actual, is(expected));
    }

    @Test
    public void testRookHorizon() {
        RookBlack rook = new RookBlack(Cell.A8);
        Cell[] actual = rook.way(rook.position(), Cell.H8);
        Cell[] expected = {Cell.B8, Cell.C8, Cell.D8, Cell.E8, Cell.F8, Cell.G8, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void testRookVertical() {
        RookBlack rook = new RookBlack(Cell.A8);
        Cell[] actual = rook.way(rook.position(), Cell.A1);
        Cell[] expected = {Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3, Cell.A2, Cell.A1};
        assertThat(actual, is(expected));
    }

    @Test
    public void testlogicWhenPawnBlack() {
        this.fillFigures(this.logicFigure);
        boolean actual = logicFigure.move(Cell.A7, Cell.A6);
        assertThat(actual, is(true));
    }

    @Test
    public void testlogicWhenRookBlackError() {
        this.fillFigures(this.logicFigure);
        boolean actual = true;
        try {
            logicFigure.move(Cell.A8, Cell.A4);
        } catch (OccupiedWayException owe) {
            actual = false;
        }
        assertThat(actual, is(false));
    }

    @Test
    public void testlogicWhenFigureNotExist() {
        this.fillFigures(this.logicFigure);
        boolean actual = true;
        try {
            logicFigure.move(Cell.A6, Cell.A4);
        } catch (FigureNotFoundException nfe) {
            actual = false;
        }
        assertThat(actual, is(false));
    }

    @Test
    public void testLogicFigureRookBlackWhenImpossibleMove() {
        RookBlack rook = new RookBlack(Cell.A8);
        boolean result = true;
        try {
            Cell[] actual = rook.way(rook.position(), Cell.B1);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

}


