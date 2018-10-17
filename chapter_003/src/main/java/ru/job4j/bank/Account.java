package ru.job4j.bank;

public class Account {
    private Integer values;
    private Integer requisites;

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

    public void setValues(Integer values) {
        this.values = values;
    }

    public void setRequisites(Integer requisites) {
        this.requisites = requisites;
    }
}
