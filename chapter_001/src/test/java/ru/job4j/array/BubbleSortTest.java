package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.08.2018
 */

public class BubbleSortTest {
    @Test
    public void sortBubble() {
        int[] noSortArray = new int[] {5, 3, 4, 8, 1, 2, 7, 6};
        BubbleSort bs = new BubbleSort();
        int[] result = bs.bSort(noSortArray);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expect));
    }
}
