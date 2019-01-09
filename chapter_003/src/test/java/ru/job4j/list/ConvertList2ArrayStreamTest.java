package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayStreamTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2ArrayStream list = new ConvertList2ArrayStream();
        Integer[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 8),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /*@Test
    public void when10ElementsThen12() {
        ConvertList2ArrayStream list = new ConvertList2ArrayStream();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                4
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsThen10() {
        ConvertList2ArrayStream list = new ConvertList2ArrayStream();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                2
        );
        int[][] expect = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen12() {
        ConvertList2ArrayStream list = new ConvertList2ArrayStream();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };
        assertThat(result, is(expect));

    }*/
}
