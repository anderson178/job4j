package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FiguresTest {
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
        RookBlack qeen = new RookBlack(Cell.A8);
        Cell[] actual = qeen.way(qeen.position(), Cell.H8);
        Cell[] expected = {Cell.B8, Cell.C8, Cell.D8, Cell.E8, Cell.F8, Cell.G8, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void testRookVertical() {
        RookBlack qeen = new RookBlack(Cell.A8);
        Cell[] actual = qeen.way(qeen.position(), Cell.A1);
        Cell[] expected = {Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3, Cell.A2, Cell.A1};
        assertThat(actual, is(expected));
    }
}


