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

    public List<Account> getAccounts(Integer srcPassport) {
        List<Account> rst = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : this.usersBank.entrySet()) {
            if (srcPassport.equals(entry.getKey().getPassport())) {
                rst = entry.getValue();
                break;
            }
        }
        return rst;
    }

    private boolean existAccount(Integer passport, Integer requisite) {
        boolean rst = false;
        List<Account> listAccounts = this.getAccounts(passport);
        for (Account account : listAccounts) {
            if (requisite.equals(account.getRequisites())) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    public boolean transferMoney(Integer srcPassport, Integer srcRequisite, Integer destPassport,
                                 Integer dstRequisite, double amount) {
        boolean user1 = this.existAccount(srcPassport, srcRequisite);
        boolean user2 = this.existAccount(destPassport, dstRequisite);


        /*Integer p = new ArrayList<User>(this.usersBank.keySet()).indexOf(srcPassport);
        List<User> us = this.usersBank.containsKey(srcPassport);*/
        return true;
    }

}
