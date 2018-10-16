package ru.job4j.Bank;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.Bank;
import ru.job4j.bank.User;
import ru.job4j.sortnumbertwo.ListCompare;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    private Bank bank = new Bank();
    private User user1 = new User("Denis", 2545324);
    private User user2 = new User("Petr", 452344);
    private User user3 = new User("Denis", 2545324);

    @Test
    public void equalsUserTrue() {
        assertThat(this.user1.equals(this.user3), is(true));
    }

    @Test
    public void equalsUserFalse() {
        assertThat(this.user1.equals(this.user2), is(false));
    }

    @Test
    public void addUser() {
        Bank bank = new Bank();
        bank.addUser(this.user1);
        bank.addUser(this.user2);
        bank.removeUser(this.user2);
    }
    @Test
    public void addAccountToUserTest() {
        this.bank.addUser(this.user1);
        this.bank.addAccountToUser(this.user1, new Account(544, 87567));
        this.bank.addAccountToUser(this.user1, new Account(8754, 8345346));
        this.bank.addAccountToUser(this.user1, new Account(17542, 35436));
    }

    @Test
    public void removeAccountToUserTest() {
        this.addAccountToUserTest();
        boolean result = this.bank.removeAccountToUser(this.user1, 8345346);
        assertThat(result, is(true));
        //list.get(1).
    }
}
