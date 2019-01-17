package ru.job4j.phonebook;

import java.util.*;

public class PhoneBook {
    private HashMap<User, List<Phone>> phoneBook = new HashMap<>();
    private boolean work = true;

    public void stop() {
        this.work = false;
    }

    private void fillPhoneBook() {
        this.phoneBook.putIfAbsent(
                new User("Мироненко", "Денис", "Сергеевич"),
                new ArrayList<>(Arrays.asList(new Phone("23232323232"), new Phone("23232323232"))));
        this.phoneBook.putIfAbsent(new User("Трепко", "Леонид", "Вадимович"), new ArrayList<>());

    }

    private void  showMenu() {
        System.out.println("------MENU------");
        System.out.println("0. Выдать список номеров");
        System.out.println("1. Выход");
        System.out.println("----------------");
        System.out.println("Выберите пункт меню");
    }

    private void init() {
        MenuBook menuBook = new MenuBook();
        this.fillPhoneBook();
        do {
            this.showMenu();
            switch (new Scanner(System.in).nextLine()){
                case "0": menuBook.showAllNumberUser(this.phoneBook);
                break;
                case "1": menuBook.exit(this);
            }
        } while (this.work);
    }

    public static void main(String[] args) {
        new PhoneBook().init();
    }
}
