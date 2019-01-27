package ru.job4j.task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.hamcrest.core.IsNull;
import org.junit.Test;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 27.1.2019
 */

public class StreamAPITest {
    @Test
    public void whenEqualse20() {
        assertThat(StreamAPI.calculate(new Integer[]{0, 1, 2, 3, 4, 5}), is(20));
    }

    @Test
    public void whenEqualse56() {
        assertThat(StreamAPI.calculate(new Integer[]{0, 1, 2, 3, 4, 5, 6}), is(56));
    }

    @Test
    public void whenResultNull() {
        assertThat(StreamAPI.calculate(new Integer[]{1, 3, 5}), is(IsNull.nullValue()));
    }

}
