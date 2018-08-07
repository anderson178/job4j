package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.08.2018
 */
public class PaintTest {
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        //String rst = paint.leftTrl(3);
        //String rst = paint.rightTrl(3);
        String rst = paint.piramid(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }
}
