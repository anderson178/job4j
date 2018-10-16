package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    private TreeMap<User, List<Account>> usersBank = new TreeMap<>();

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

    public TreeMap<User, List<Account>> getUsersBank() {
        return this.usersBank;
    }

    public List<Account> getAccounts(User user) {
        return this.usersBank.get(user);
    }

}
