package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

	/**
	* Test.
	*
	* @author Denis Mironenko
	* @version 1.0
	* @since 29.07.2018
	*/
public class CalculateTest {
	/**
	* Test echo.
	*/ @Test
public void whenTakeNameThenTreeEchoPlusName() {
	String input = "Denis Mironenko";
	String expect = "Echo, echo, echo : Denis Mironenko";
	Calculate calc = new Calculate();
	String result = calc.echo(input); 
	assertThat(result, is(expect));
}
}