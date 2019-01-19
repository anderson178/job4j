package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.01.2019
 */

public class PriorityQueueStreamTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueueStream();
        queue.put(new Task("middle", 5));
        queue.put(new Task("middle", 4));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 8));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}
