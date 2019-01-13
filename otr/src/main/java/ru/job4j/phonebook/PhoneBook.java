package ru.job4j.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<User, List<Phone>> phoneBook = new HashMap<>();

    public void addNumberUser(User user, Phone phone) {
        this.phoneBook.get(user).add(phone);
    }

    public void userAdd(User user) {
        this.phoneBook.putIfAbsent(user, new ArrayList<>());
    }

    public void showAllNumberUser (User user) {
        int count = 1;
        if (this.phoneBook.get(user) != null) {
            if (this.phoneBook.get(user).size() != 0) {
                System.out.println("Номера телефонов: " + user.toString());
                for (Phone phone : this.phoneBook.get(user)) {
                    System.out.println(count++ + ". " + phone.toString());
                }
            } else {
                System.out.println("У пользователя с ФИО:  "+ user.toString() +" - нет номеров.");
            }

        } else {
            System.out.println("Пользователя с ФИО: "+ user.toString() +" - в БД нет.");
        }

    }
}
