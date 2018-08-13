package ru.job4j.my;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.08.2018
 */

public class NumberPolindromTest {
    @Test
    public void checkPolindromTestWhenTrue() {
        NumberPolindrom np = new NumberPolindrom();
        int[] mas = {3, 1, 2, 1, 2, 1, 3};
        boolean result = np.checkPol(mas);
        boolean expect = true;
        assertThat(result, is(expect));
    }
    @Test
    public void checkPolindromTestWhenFalse() {
        NumberPolindrom np = new NumberPolindrom();
        int[] mas = {3, 1, 2, 1, 2, 1, 4};
        boolean result = np.checkPol(mas);
        boolean expect = false;
        assertThat(result, is(expect));
    }
}
