package ru.job4j.array;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMergeSort {
    @Test
    public void whenEvenNumber() {
       // Integer[] mas = new Integer[] {2, 3, 17, 7, 8, 9, 1, 4, 6, 9, 2, 3, 1, 18};
        MergeSort sort = new MergeSort();
        sort.sort(new ArrayList<>(Arrays.asList(2, 3, 17, 7, 8, 9, 1, 4, 6, 9, 2, 3, 1, 18)));


    }
}
