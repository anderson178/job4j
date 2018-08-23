package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2",  "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenCoincidesNameReturnListName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        Item second = new Item("test2", "testDescription2");
        tracker.add(second);
        Item third = new Item("test1", "testDescription3");
        tracker.add(third);
        Item[] items = new Item[2];
        items[0] = first;
        items[1] = third;
        assertThat(tracker.findByName("test1"), is(items));
    }
    @Test
    public void whenFindidreturnItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        String id = first.getId();
        assertThat(tracker.findById(id), is(first));
    }
}
