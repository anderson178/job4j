package ru.job4j.figures;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Метод-тесты для операций в трекере
 * @author Денис Мироненко
 * @version $Id$
 * @since 03.09.2018
 */

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String ln = System.lineSeparator();
        int size = 4;
        assertThat(
                square.draw(size),
                is(
                        new StringBuilder()
                                .append("# # # # ")
                                .append(ln)
                                .append("# # # # ")
                                .append(ln)
                                .append("# # # # ")
                                .append(ln)
                                .append("# # # # ")
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        String ln = System.lineSeparator();
        int size = 4;
        assertThat(
                triangle.draw(size),
                is(
                        new StringBuilder()
                                .append("   ^   ")
                                .append(ln)
                                .append("  ^^^  ")
                                .append(ln)
                                .append(" ^^^^^ ")
                                .append(ln)
                                .append("^^^^^^^")
                                .toString()
                )
        );
    }

}
