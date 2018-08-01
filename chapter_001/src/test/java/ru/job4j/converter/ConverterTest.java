package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60RubleToDollarThen2() {
        Converter conv = new Converter();
        int result = conv.rubleToDollar(120);
        assertThat(result, is(2));
    }
    @Test
    public void when70RubleToEvtoThen2() {
        Converter conv = new Converter();
        int result = conv.rubleToEuro(140);
        assertThat(result, is(2));
    }
    @Test
    public void when2DollarToRuble120() {
        Converter conv = new Converter();
        int result = conv.dollarToRubli(2);
        assertThat(result, is(120));
    }
    @Test
    public void when2EvroToRuble140() {
        Converter conv = new Converter();
        int result = conv.euroToRubli(2);
        assertThat(result, is(140));
    }
}
