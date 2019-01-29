package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest2 {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck2 check = new MatrixCheck2();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono2(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataMonoByTrueThenFalse() {
        MatrixCheck2 check = new MatrixCheck2();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, false, true},
                {false, false, true}
        };
        boolean result = check.mono2(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByTrueThenTrue2() {
        MatrixCheck2 check = new MatrixCheck2();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {false, false, true}
        };
        boolean result = check.mono2(input);
        assertThat(result, is(true));
    }
}
