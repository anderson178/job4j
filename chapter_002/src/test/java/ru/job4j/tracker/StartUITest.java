package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Метод-тесты для операций в трекере
 * @author Денис Мироненко
 * @version $Id$
 * @since 31.08.2018
 */

public class StartUITest {
    private Tracker tracker = new Tracker();
    private Item item1 = tracker.add(new Item("test name", "desc"));
    private Item item2 = tracker.add(new Item("test2 name2", "desc2"));

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[] {"0", "test name", "desc", "y", "0", "test2 name2", "desc2", "n"});
        new StartUI(input, this.tracker).startProgr();
        assertThat(this.tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void whenUserEditItem() {
        String id = this.item1.getId();
        Input input = new StubInput(new String[] {"2", id, "test3 name3", "desc3", "y", "1", "n"});
        new StartUI(input, this.tracker).startProgr();
        assertThat(this.tracker.findById(this.item1.getId()).getName(), is ("test3 name3"));
    }

    @Test
    public void whenUserRemoveItem() {
        String id = this.item1.getId();
        Input input = new StubInput(new String[] {"3", id, "y", "1", "n"});
        new StartUI(input, this.tracker).startProgr();
        Item[] expected = new Item[]{this.item2};
        assertThat(this.tracker.getAll(), is (expected));
    }
}
