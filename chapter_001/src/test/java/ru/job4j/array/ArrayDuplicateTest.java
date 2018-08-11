package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.08.2018
 */

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate mas = new ArrayDuplicate();
        String[] temp = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = mas.remove(temp);
        String[] expect = new String[] {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateAllHello() {
        ArrayDuplicate mas = new ArrayDuplicate();
        String[] temp = new String[] {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] result = mas.remove(temp);
        String[] expect = new String[] {"Привет"};
        assertThat(result, is(expect));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateAllHello2() {
        ArrayDuplicate mas = new ArrayDuplicate();
        String[] temp = new String[] {"Привет", "Привет", "Привет", "Привет", "Супер"};
        String[] result = mas.remove(temp);
        String[] expect = new String[] {"Привет", "Супер"};
        assertThat(result, is(expect));
    }
}
