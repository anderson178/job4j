package ru.job4j.bank;

import javax.swing.*;
import java.util.*;

public class Bank {
    private HashMap<User, List<Account>> usersBank = new HashMap<>();

    public void addUser(User user) {
        this.usersBank.put(user, new ArrayList<>());
    }

    public void removeUser(User user) {
        this.usersBank.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        this.usersBank.get(user).add(account);
    }

    /**
     * метод удаления банковского счета по реквизитам.
     *
     * @param user
     * @param requisites
     * @return
     */
    public boolean removeAccountToUser(User user, int requisites) {
        List<Account> list = this.usersBank.get(user);
        int index;
        boolean rst = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRequisites() == requisites) {
                index = i;
                this.usersBank.get(user).remove(index);
                rst = true;
                break;
            }
        }
        return rst;
    }

    public HashMap<User, List<Account>> getUsersBank() {
        return this.usersBank;
    }

    public List<Account> getAccounts(User user) {
        return this.usersBank.get(user);
    }

    /*private boolean existAccount(Integer passport, Integer requisite) {
        boolean rst = false;
        List<Account> listAccounts = this.getAccounts(passport,requisite);
        for (Account account : listAccounts) {
            if (requisite.equals(account.getRequisites())) {
                rst = true;
                break;
            }
        }
        return rst;
    }*/

    public User userBank(Integer passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : this.usersBank.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                user = entry.getKey();
                break;
            }
        }
        return user;
    }

    private Account actualAccount(User user, Integer requisite) {
        Account account = null;
        List<Account> listAccounts = this.getAccounts(user);
        for (Account temp : listAccounts) {
            if (requisite.equals(temp.getRequisites())) {
                account = temp;
                break;
            }
        }
        return account;

    }

    public boolean transferMoney(Integer srcPassport, Integer srcRequisite, Integer destPassport,
                                 Integer dstRequisite, double amount) {
        boolean result = false;
        User firstUser = this.userBank(srcPassport);
        User secondUser = this.userBank(destPassport);
        if (firstUser != null && secondUser != null) {
            Account accountFirstUser = this.actualAccount(firstUser, srcRequisite);
            Account accountSecondUser = this.actualAccount(secondUser, dstRequisite);
            if (accountFirstUser != null && accountSecondUser != null) {
                result = accountFirstUser.transferAmount(accountSecondUser, amount);
            }

        }
        return result;
    }

}
