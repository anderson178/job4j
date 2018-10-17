package ru.job4j.bank;

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

    public void setValues(Integer values) {
        this.values = values;
    }


    public void setRequisites(Integer requisites) {
        this.requisites = requisites;
    }

    boolean transferAmount(Account destination, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.values) {
            this.values -= amount;
            destination.values += amount;
            result = true;
        }
        return result;
    }
}
