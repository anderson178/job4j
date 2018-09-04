package ru.job4j.figures;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Денис Мироненко
 * @version $Id$
 * @since 04.09.2018
 */

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        int size = 4;
        String ln = System.lineSeparator();
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square(), size);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("# # # # ")
                                .append(ln)
                                .append("# # # # ")
                                .append(ln)
                                .append("# # # # ")
                                .append(ln)
                                .append("# # # # ")
                                .append(ln)
                                .toString()
                )
        );
        System.setOut(stdout);
    }
    @Test
    public void whenDrawTriangle() {
        int size = 4;
        String ln = System.lineSeparator();
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle(), size);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   ^   ")
                                .append(ln)
                                .append("  ^^^  ")
                                .append(ln)
                                .append(" ^^^^^ ")
                                .append(ln)
                                .append("^^^^^^^")
                                .append(ln)
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}

