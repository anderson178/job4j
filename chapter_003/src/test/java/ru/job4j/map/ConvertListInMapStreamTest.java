package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListInMapStreamTest {
    private User2 user1 = new User2(0, "Denis", "Piter");
    private User2 user2 = new User2(1, "Vasiliy", "Moscow");

    @Test
    public void convertListMap() {
        ConvertListInMapStream convert = new ConvertListInMapStream();
        List<User2> list = List.of(
                this.user1,
                this.user2
        );
        Map<Integer, User2> result = convert.convert(list);
        Map<Integer, User2> expect = Map.of(
                this.user1.getId(), this.user1,
                this.user2.getId(), this.user2
        );
        assertThat(result, is(expect));
    }
}
