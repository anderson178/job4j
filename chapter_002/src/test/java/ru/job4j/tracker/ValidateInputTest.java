package ru.job4j.tracker;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.09.2018
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private String ln = System.lineSeparator();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            range.add(i);
        }
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "0"}));
        input.ask("Select: ", range);
        assertThat(this.mem.toString(), is("Please enter validate data again" + this.ln));
    }


}
