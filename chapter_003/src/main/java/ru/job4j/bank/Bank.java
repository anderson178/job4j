package ru.job4j.bank;
import java.util.stream.*;

import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.10.2018
 */

public class Bank {
    private HashMap<User, List<Account>> usersBank = new HashMap<>();

    /**
     * метод добавления пользователя
     *
     * @param user - пользователь
     */
    public void addUser(User user) {
        this.usersBank.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод удаления пользователя
     *
     * @param user - пользователь
     */
    public void removeUser(User user) {
        this.usersBank.remove(user);
    }

    /**
     * метод добавления банковского счета пользовтелю
     *
     * @param user    - пользоватеьл
     * @param account - банковский счет
     */
    public void addAccountToUser(User user, Account account) {
        this.usersBank.get(user).add(account);
        //this.usersBank.isEmpty();
    }

    /**
     * метод удаления банковского счета по реквизитам.
     *
     * @param user       - пользователь
     * @param requisites - банковские реквизиты
     * @return - true если аккаутн удален, иначе false
     */
    public boolean removeAccountToUser(User user, int requisites) {
        //List<Account> listTemp = usersBank.entrySet().stream().filter(userListEntry -> user.equals(userListEntry.getKey().)).map(map -> map.getKey()).collect(Collectors.toList());
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

    /**
     * метод возврата дерева пользователей и их банковских счетов
     *
     * @return - струкура содержащая key - пользователь, account - банковский счет
     */
    public HashMap<User, List<Account>> getUsersBank() {
        return this.usersBank;
    }

    /**
     * метод поиска банковских счетов по необходимому польщователю
     *
     * @param user - пользователь
     * @return - список банковских счетов
     */
    public List<Account> getAccounts(User user) {
        return this.usersBank.get(user);
    }

    /**
     * метод поиска пользователя по паспорту
     *
     * @param passport - паспорт
     * @return - пользователь
     */
    private User userBank(Integer passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : this.usersBank.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                user = entry.getKey();
                break;
            }
        }
        return user;
    }

    /**
     * метод поиска банковского счета по реквизитам
     *
     * @param passport      - паспорт пользователя
     * @param requisite - реквизиты банковского счета
     * @return - банковсий счет
     */
    private Account existAccount(Integer passport, Integer requisite) {
        Account account = null;
        List<Account> listAccounts = this.getAccounts(this.userBank(passport));
        for (int i = 0; listAccounts != null && i < listAccounts.size(); i++) {
            if (requisite.equals(listAccounts.get(i).getRequisites())) {
                account = listAccounts.get(i);
                break;
            }
        }
        return account;
    }

    /**
     * метод перевода средств с одного счета на другой
     *
     * @param srcPassport  - паспорт отправителя
     * @param srcRequisite - банковские реквизиты отправителя
     * @param destPassport - паспорт получателя
     * @param dstRequisite - банковские реквихиты получателя
     * @param amount       - количество средств для передачи
     * @return - если передача осуществлена то вернет true Иначе false
     */
    public boolean transferMoney(Integer srcPassport, Integer srcRequisite, Integer destPassport,
                                 Integer dstRequisite, double amount) {
        boolean result = false;
        Account accountFirstUser = this.existAccount(srcPassport, srcRequisite);
        Account accountSecondUser = this.existAccount(destPassport, dstRequisite);
        if (accountFirstUser != null && accountSecondUser != null) {
                result = accountFirstUser.transferAmount(accountSecondUser, amount);
        }
        return result;
    }

}
