package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 06.08.2018
 */

public class FactorialTest {
    @Test
    public void calculatorFactorial() {
        Factorial calcFact = new Factorial();
        int result = calcFact.calculationFactorial(5);
        assertThat(result, is(120));
    }
}
