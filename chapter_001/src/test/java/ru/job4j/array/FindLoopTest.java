package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.08.2018
 */

public class FindLoopTest {

    @Test
    public void whenArrayHasLengh5Then3() {
        FindLoop fndEl = new FindLoop();
        int[] mas = new int[]{1, 4, 6, 5, 8, 9};
        int result = fndEl.indexOf(mas, 5);
        int expect = 3;
        assertThat(result, is(expect));
    }

}
