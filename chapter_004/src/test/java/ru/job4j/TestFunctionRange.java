package ru.job4j;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestFunctionRange {
    @Test
    public void whenLinFunction() {
        FunctionRange func = new FunctionRange();
        ArrayList<Double> rst = new ArrayList<>();
        int k = 2, b = 4;
        rst.addAll(func.function(1, 10, (x) -> k * x + b));
        assertThat(rst, is(Arrays.asList(6D, 8D, 10D, 12D, 14D, 16D, 18D, 20D, 22D)));
    }

    @Test
    public void whenQuadrFunction() {
        FunctionRange func = new FunctionRange();
        ArrayList<Double> rst = new ArrayList<>();
        int a = 1, b = 2, c = 3;
        rst.addAll(func.function(1, 10, (x) -> a * Math.pow(x, 2) + b * x + c));
        System.out.println(rst);
        assertThat(rst, is(Arrays.asList(6D, 11D, 18D, 27D, 38D, 51D, 66D, 83D, 102D)));
    }

    @Test
    public void whenLogFunction() {
        FunctionRange func = new FunctionRange();
        ArrayList<Double> rst = new ArrayList<>();
        int a = 1, b = 2, c = 3;
        rst.addAll(func.function(1, 10, (x) -> Math.floor(Math.log(x))));
        System.out.println(rst);
        assertThat(rst, is(Arrays.asList(0D, 0D, 1D, 1D, 1D, 1D, 1D, 2D, 2D)));
    }
}
