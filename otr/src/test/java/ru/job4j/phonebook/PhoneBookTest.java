package ru.job4j.phonebook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class PhoneBookTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String ln = System.lineSeparator();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    public void whenShowNumbersUser() {

    }
   // private User user1 = new User("Мироненко", "Денис", "Сергеевич");
    //private User user2 = new User("Трепко", "Леонид", "Вадимович");

   /* @Test
    public void addNumberUser() {
        PhoneBook pb = new PhoneBook();
        pb.userAdd(user1);
        pb.userAdd(user2);
        pb.addNumberUser(user1, new Phone("23232323232"));
        pb.addNumberUser(user1, new Phone("23546574765"));
        int p = 0;
    }

    @Test
    public void showNumberUser1() {
        PhoneBook pb = new PhoneBook();
        pb.userAdd(user1);
        pb.userAdd(user2);
        pb.addNumberUser(user1, new Phone("23232323232"));
        pb.addNumberUser(user1, new Phone("23546574765"));
        //pb.showAllNumberUser(user1);
        //pb.showAllNumberUser(user2);
       // pb.showAllNumberUser(new User("ssds", "sd", "sd"));
    }*/


}
