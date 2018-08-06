package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 06.08.2018
 */

public class CounterTest {
    @Test
    public void addtest() {
        Counter cntr = new Counter();
        int result = cntr.add(1, 10);
        assertThat(result, is(30));
    }

}
