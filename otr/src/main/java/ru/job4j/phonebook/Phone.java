package ru.job4j.phonebook;

public class Phone {
    private String number;

    public Phone(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return number;
    }
}
