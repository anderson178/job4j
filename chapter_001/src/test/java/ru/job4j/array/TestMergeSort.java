package ru.job4j.array;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 22.11.2018
 */

public class TestMergeSort {
    @Test
    public void mergeSort() {
        MergeSort mrSort = new MergeSort();
        List<Integer> result = new ArrayList<>(Arrays.asList(2, 3, 17, 7, 8, 9, 1, 4, 6, 9, 2, 3, 1, 18));
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 6, 7, 8, 9, 9, 17, 18));
        assertThat(mrSort.sort(result), is(expect));
    }
}
