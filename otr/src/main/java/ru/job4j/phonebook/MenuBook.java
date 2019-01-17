package ru.job4j.phonebook;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MenuBook {
    private Scanner scaner = new Scanner(System.in);

    private User inputUser() {
        System.out.println("Введите Фамилию");
        String surname = scaner.nextLine();
        System.out.println("Введите имя");
        String name = scaner.nextLine();
        System.out.println("Введите отчество");
        String patronymic = scaner.nextLine();
        return new User(surname, name, patronymic);
    }

    public void showAllNumberUser(HashMap<User, List<Phone>> phoneBook) {
        int count = 1;
        User user = this.inputUser();
        if (phoneBook.get(user) != null) {
            if (phoneBook.get(user).size() != 0) {
                System.out.println("Номера телефонов: " + user.toString());
                for (Phone phone : phoneBook.get(user)) {
                    System.out.println(count++ + ". " + phone.toString());
                }
            } else {
                System.out.println("У пользователя с ФИО:  " + user.toString() + " - нет номеров.");
            }

        } else {
            System.out.println("Пользователя с ФИО: " + user.toString() + " - в БД нет.");
        }

    }

    public void exit(PhoneBook phoneBook) {
        System.out.println("Выход из программы");
        phoneBook.stop();
    }
}
