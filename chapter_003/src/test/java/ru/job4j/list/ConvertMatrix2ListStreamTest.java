package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListStreamTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2ListStream list = new ConvertMatrix2ListStream();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on3ArrayThenList6() {
        ConvertMatrix2ListStream list = new ConvertMatrix2ListStream();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on3ArrayThenList9() {
        ConvertMatrix2ListStream list = new ConvertMatrix2ListStream();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
