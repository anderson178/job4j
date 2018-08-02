package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 02.08.2018
 */

public class DummyBotTest {
    @Test
    public void whenGreetBot() {
        DummyBot db = new DummyBot();
        String answr = db.answer("Привет, Бот.");
        String expected = "Привет, умник.";
        assertThat(answr, is(expected));
    }
    @Test
    public void whenByuBot() {
        DummyBot db = new DummyBot();
        String answr = db.answer("Пока.");
        String expected = "До скорой встречи.";
        assertThat(answr, is(expected));
    }
    @Test
    public void whenUnknownBot() {
        DummyBot db = new DummyBot();
        String answr = db.answer("Бот, включай мозги");
        String expected = "Это ставит меня в тупик. Спросите другой вопрос.";
        assertThat(answr, is(expected));
    }
}
