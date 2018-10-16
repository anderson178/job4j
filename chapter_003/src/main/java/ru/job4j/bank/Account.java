package ru.job4j.bank;

public class Account {
    private int values;
    private int requisites;

    public Account(int values, int requisites) {
        this.values = values;
        this.requisites = requisites;
    }


    public int getValues() {
        return this.values;
    }

    public int getRequisites() {
        return this.requisites;
    }

    @Override
    public String toString() {
        return "Account{" + "values=" + this.values + ", requisites=" + this.requisites + '}';
    }
}
