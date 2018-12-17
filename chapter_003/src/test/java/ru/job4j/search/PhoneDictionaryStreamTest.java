package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryStreamTest {
    private PhoneDictionaryStream phones = new PhoneDictionaryStream();

    private void personFill() {
        this.phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        this.phones.add(
                new Person("Denis", "Mironenko", "124597", "Saint-Petersburg")
        );
    }

    @Test
    public void whenFindByName() {
        this.personFill();
        List<Person> persons = phones.find("459");
        assertThat(persons.iterator().next().getSurname(), is("Mironenko"));
    }

    @Test
    public void whenFindBySurname() {
        this.personFill();
        List<Person> persons = phones.find("Mironenko");
        assertThat(persons.iterator().next().getSurname(), is("Mironenko"));
    }

    @Test
    public void whenFindByAddress() {
        this.personFill();
        List<Person> persons = phones.find("Bryansk");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        this.personFill();
        List<Person> persons = phones.find("597");
        assertThat(persons.iterator().next().getSurname(), is("Mironenko"));
    }
}
