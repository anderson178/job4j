package ru.job4j.bank;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.10.2018
 */

public class Account {
    private double values;
    private Integer requisites;

    public Account(int values, int requisites) {
        this.values = values;
        this.requisites = requisites;
    }


    public double getValues() {
        return this.values;
    }

    public int getRequisites() {
        return this.requisites;
    }

    @Override
    public String toString() {
        return "Account{" + "values=" + this.values + ", requisites=" + this.requisites + '}';
    }

    /**
     * метод перевода средств с одного счета на другой
     *
     * @param destination - счет на который необьходимо перевести
     * @param amount - количество средств
     * @return - если перевод осущствлен то вернет true иначе false
     */
    public boolean transferAmount(Account destination, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.values) {
            this.values -= amount;
            destination.values += amount;
            result = true;
        }
        return result;
    }
}
