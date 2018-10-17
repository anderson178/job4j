package ru.job4j.map;

import org.junit.Test;
import ru.job4j.map.User2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 04.10.2018
 */

public class ConvertListInMapTest {
    private User2 user1 = new User2(0, "Denis", "Piter");
    private User2 user2 = new User2(1, "Vasiliy", "Moscow");

    @Test
    public void convertListMap() {
        ConvertListInMap convert = new ConvertListInMap();
        List<User2> list = new ArrayList<>();
        list.add(this.user1);
        list.add(this.user2);
        HashMap<Integer, User2> result = convert.convert(list);
        HashMap<Integer, User2> expect = new HashMap<>();
        expect.put(this.user1.getId(), this.user1);
        expect.put(this.user2.getId(), this.user2);
        assertThat(result, is(expect));
    }


}
