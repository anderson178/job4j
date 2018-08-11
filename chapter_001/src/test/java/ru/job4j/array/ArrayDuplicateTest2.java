package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.08.2018
 */

public class ArrayDuplicateTest2 {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate2 mas = new ArrayDuplicate2();
        String[] temp = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = mas.remove(temp);
        String[] expect = new String[] {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));

    }
}
