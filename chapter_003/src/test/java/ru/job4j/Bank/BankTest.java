package ru.job4j.Bank;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.Bank;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    private String ln = System.lineSeparator();
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
        assertThat(bank.getUsersBank().containsKey(this.user1), is (true));

    }

    @Test
    public void removeUser() {
        Bank bank = new Bank();
        bank.addUser(this.user1);
        bank.addUser(this.user2);
        bank.removeUser(this.user2);
        assertThat(bank.getUsersBank().containsKey(this.user2), is (false));
    }

    @Test
    public void addAccountToUserTest() {
        Bank bank = new Bank();
        bank.addUser(this.user1);
        bank.addAccountToUser(this.user1, new Account(544, 87567));
        bank.addAccountToUser(this.user1, new Account(8754, 8345346));
        List<Account> result = bank.getAccounts(2545324);
        List<Account> expect = new ArrayList<>(Arrays.asList(
                new Account(544, 87567),
                new Account(8754, 8345346)
        ));
        assertThat(result.get(1).toString(), is(expect.get(1).toString()));
    }

    @Test
    public void removeAccountToUserTest() {
        Bank bank = new Bank();
        bank.addUser(this.user1);
        bank.addAccountToUser(this.user1, new Account(544, 87567));
        bank.addAccountToUser(this.user1, new Account(8754, 8345346));
        bank.addAccountToUser(this.user1, new Account(17542, 35436));
        boolean result = bank.removeAccountToUser(this.user1, 8345346);
        assertThat(result, is(true));
    }

    @Test
    public void getAccountsToUserTest() {
        Bank bank = new Bank();
        bank.addUser(this.user1);
        bank.addAccountToUser(this.user1, new Account(544, 87567));
        bank.addAccountToUser(this.user1, new Account(8754, 8345346));
        List<Account> temp = bank.getAccounts(2545324);
        List<Account> temp2 = new ArrayList<>(Arrays.asList(
                new Account(544, 87567),
                new Account(8754, 8345346)
        ));
        StringBuilder result = new StringBuilder();
        result.append(temp.get(0).toString());
        result.append(this.ln);
        result.append(temp.get(1).toString());
        StringBuilder expect = new StringBuilder();
        expect.append(temp2.get(0).toString());
        expect.append(this.ln);
        expect.append(temp2.get(1).toString());
        assertThat(result.toString(), is (expect.toString()));
    }

    @Test
    public void transferMoneyUser1ToUser2() {
        Bank bank = new Bank();
        bank.addUser(this.user1);
        bank.addAccountToUser(this.user1, new Account(544, 87567));
        bank.addAccountToUser(this.user1, new Account(8754, 8345346));
        bank.addUser(this.user2);
        bank.addAccountToUser(this.user2, new Account(11445, 87567));
        bank.addAccountToUser(this.user2, new Account(7899, 8345346));
        double amount = 100;
        bank.transferMoney(2545324, 87567, 452344, 87567, amount);
    }
}
