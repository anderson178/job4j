package ru.job4j.bank;

import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.01.2019
 */

public class BankStream {
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
        boolean rst = false;
        if (this.usersBank.get(user) != null) {
            Optional<Account> accountUser = this.usersBank.get(user).stream().filter(account ->
                    account.getRequisites() == requisites).findFirst();
            if (accountUser.isPresent()) {
                this.usersBank.get(user).remove(accountUser.get());
                rst = true;
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
        if (!this.usersBank.entrySet().isEmpty()) {
            Optional<Map.Entry<User, List<Account>>> userOpt = this.usersBank.entrySet().stream().filter(Objects::nonNull).filter(value ->
                    passport.equals(value.getKey().getPassport())).findFirst();
            if (userOpt.isPresent()) {
                user = userOpt.get().getKey();
            }
        }
        return user;
    }

    /**
     * метод поиска банковского счета по реквизитам
     *
     * @param passport  - паспорт пользователя
     * @param requisite - реквизиты банковского счета
     * @return - банковсий счет
     */
    private Account existAccount(Integer passport, Integer requisite) {
        Account account = null;
        List<Account> listAccounts = this.getAccounts(this.userBank(passport));
        if (listAccounts != null) {
            Optional<Account> accountOpt = listAccounts.stream().filter(value -> requisite.equals(value.getRequisites())).findFirst();
            if (accountOpt.isPresent()) {
                account = accountOpt.get();
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
