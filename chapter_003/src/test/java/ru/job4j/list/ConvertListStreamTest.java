package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListStreamTest {

    @Test
    public void when2ListArray() {
        ConvertListStream convert = new ConvertListStream();
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6}
        );
        List<Integer> result = convert.convert(list);
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6
        );
        assertThat(result, is(expect));
    }

    @Test
    public void when3ListArray() {
        ConvertListStream convert = new ConvertListStream();
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6},
                new int[]{7, 8, 9}
        );
        List<Integer> result = convert.convert(list);
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        assertThat(result, is(expect));
    }
}
