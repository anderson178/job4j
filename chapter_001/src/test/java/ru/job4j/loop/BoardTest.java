package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 07.08.2018
 */

public class BoardTest {
    @Test
    public void when3x3() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(String.format("X X%s X %sX X%s", ln, ln, ln)));
    }
    @Test
    public void when5x5() {
        Board board = new Board();
        String result = board.paint(5, 5);
        String ln = System.lineSeparator();
        assertThat(result, is(String.format("X X X%s X X %sX X X%s X X %sX X X%s", ln, ln, ln, ln, ln)));
    }
}
