package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SortByChoiceTest {
    @Test
    public void sortChoiceTest() {
        SortByChoice choice = new SortByChoice();
        int[] mas = new int[] {3, 7, 4, 4, 6, 5, 8, 1, 10};
        choice.sort(mas);
        int[] expect = new int[] {1, 3, 4, 4, 5, 6, 7, 8, 10};
        assertThat(mas, is(expect));
    }

}
