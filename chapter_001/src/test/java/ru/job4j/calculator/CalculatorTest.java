package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void oneDivTwo(){
        Calculator calc = new Calculator();
        calc.div(1D,1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    @Test
    public void oneMultipleTwo(){
        Calculator calc = new Calculator();
        calc.multiple(2D,3D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }
    @Test
    public void oneSubtractTwo(){
        Calculator calc = new Calculator();
        calc.subtract(10D,23D);
        double result = calc.getResult();
        double expected = -13D;
        assertThat(result, is(expected));
    }
}

