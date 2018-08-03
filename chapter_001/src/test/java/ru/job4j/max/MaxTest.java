package ru.job4j.max;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 03.08.2018
 */

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        String result = maxim.summation(2, 4);
        assertThat(result, is("Второе число " + 4 + " больше чем первое " + 2));
    }
}
