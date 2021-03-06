package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataMonoByTrueThenTrue2() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoByTrueThenFalseFour() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, true, true},
                {true, true, false, false},
                {true, false, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByTrueThenTrueFour() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, true, true},
                {true, true, true, false},
                {true, false, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
