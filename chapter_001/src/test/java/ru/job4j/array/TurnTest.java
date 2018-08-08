package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.08.2018
 */

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.turnMas(input);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray2() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5, 6};
        int[] result = turner.turnMas(input);
        int[] expect = new int[] {6, 5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

}
