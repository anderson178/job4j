package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 15.08.2018
 */

public class ArraySortForMas3Test {
    @Test
    public void testSortMas3() {
        int[] masA = {1, 11, 21 ,31};
        int[] masB = {2, 4, 5, 8};
        ArraySortForMas3 sort = new ArraySortForMas3();
        int[] result = sort.sortMas3(masA, masB);
        int[] expect = new int[] {1, 2, 5, 7, 8, 10, 13, 15};
        assertThat(result, is(expect));
    }
}
