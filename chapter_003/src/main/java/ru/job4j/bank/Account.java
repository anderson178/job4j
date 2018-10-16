package ru.job4j.bank;

public class Account {
    int values;
    private int requisites;

    public Account(int values, int requisites) {
        this.values = values;
        this.requisites = requisites;
    }
   // public void

    public int getValues() {
        return values;
    }

    public int getRequisites() {
        return requisites;
    }
}
