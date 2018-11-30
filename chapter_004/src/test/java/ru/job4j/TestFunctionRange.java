package ru.job4j;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestFunctionRange {
    @Test
    public void whenLinFinction() {
        FunctionRange func = new FunctionRange();
        ArrayList<Double> rst = new ArrayList<>() ;
        rst.addAll(func.linFunction(1, 10, (x) -> 2 * x + 4));
        assertThat(rst, is(Arrays.asList(6D, 8D, 10D, 12D, 14D, 16D, 18D, 20D, 22D)));
    }
}
