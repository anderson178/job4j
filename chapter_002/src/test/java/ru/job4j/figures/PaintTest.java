package ru.job4j.figures;
import org.junit.After;
import org.junit.Before;
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
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private int size = 4;
    private String ln = System.lineSeparator();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square(), this.size);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("# # # # ")
                                .append(this.ln)
                                .append("# # # # ")
                                .append(this.ln)
                                .append("# # # # ")
                                .append(this.ln)
                                .append("# # # # ")
                                .append(this.ln)
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle(), this.size);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   ^   ")
                                .append(this.ln)
                                .append("  ^^^  ")
                                .append(this.ln)
                                .append(" ^^^^^ ")
                                .append(this.ln)
                                .append("^^^^^^^")
                                .append(this.ln)
                                .toString()
                )
        );
    }
}

