package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 16.08.2018
 */

public class ArraySortForMas3Test {
    @Test
    public void testSortMas31() {
        int[] masA = {1, 11, 21, 31};
        int[] masB = {2, 4, 5, 8};
        ArraySortForMas3 sort = new ArraySortForMas3();
        int[] result = sort.sortMas3(masA, masB);
        int[] expect = new int[]{1, 2, 4, 5, 8, 11, 21, 31};
        assertThat(result, is(expect));
    }

    @Test
    public void testSortMas32() {
        int[] masA = {8, 11, 21, 31};
        int[] masB = {2, 3, 4, 64};
        ArraySortForMas3 sort = new ArraySortForMas3();
        int[] result = sort.sortMas3(masA, masB);
        int[] expect = new int[]{2, 3, 4, 8, 11, 21, 31, 64};
        assertThat(result, is(expect));
    }

    @Test
    public void testSortMas33() {
        int[] masA = {1, 2, 3, 4};
        int[] masB = {5, 6, 7, 8};
        ArraySortForMas3 sort = new ArraySortForMas3();
        int[] result = sort.sortMas3(masA, masB);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expect));
    }
    @Test
    public void testSortMas34() {
        int[] masA = {1, 2, 45, 46};
        int[] masB = {5, 7, 10, 11};
        ArraySortForMas3 sort = new ArraySortForMas3();
        int[] result = sort.sortMas3(masA, masB);
        int[] expect = new int[]{1, 2, 5, 7, 10, 11, 45, 46};
        assertThat(result, is(expect));
    }
    @Test
    public void testSortMas35() {
        int[] masA = new int[0];
        int[] masB = {2, 4, 5, 8};
        ArraySortForMas3 sort = new ArraySortForMas3();
        int[] result = sort.sortMas3(masA, masB);
        int[] expect = new int[]{2, 4, 5, 8};
        assertThat(result, is(expect));
    }
}
