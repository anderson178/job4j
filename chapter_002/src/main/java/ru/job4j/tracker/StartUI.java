package ru.job4j.tracker;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 29.08.2018
 */

public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private Tracker tracker;
    private Item[] items;
    private Input input;
    private int countWrong = 0;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод запроса повторноо выобра команды меню
     */
    private void checkAnswer() {

        String answer = this.input.ask("Do you want to continue working in the tracker? (y/n)");
        if (answer.equals("y")) {
            startProgr();
        } else {
            this.exit();
        }
    }

    /**
     * выход из консоли
     */
    private void exit() {
        System.out.println("Goode bye");

    }

    /**
     * Метод добавления новой заявки
     */
    public void add() {
        this.countWrong = 0;
        System.out.println("You selection ADD");
        String name = this.input.ask("input name Item");
        String desc = input.ask("input description");
        this.tracker.add(new Item(name, desc));
        System.out.println("Item create");
        this.checkAnswer();
    }

    /**
     * Метод вывода массива заявок
     * @param items - массив заявок
     */
    public void showAll(Item[] items) {
        this.countWrong = 0;
        if (items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.print("id: " + items[i].getId() + ". ");
                System.out.print("Name: " + items[i].getName() + ". ");
                System.out.print("Description: " + items[i].getDescription() + ". ");
                System.out.print("Date create: " + items[i].getCreate() + ".\n");
            }
        } else {
            System.out.println("Список пуст");
        }
        this.checkAnswer();
    }

    /**
     * метод удаления заявки
     */
    public void remove() {
        this.countWrong = 0;
        System.out.println("You selection DELETE");
        String id = this.input.ask("input id item:");
        this.tracker.remove(id);
        System.out.println("Item remove");
        this.checkAnswer();
    }

    /**
     * Метод редактирвоания заявки
     */
    public void edit() {
        this.countWrong = 0;
        System.out.println("You selection EDIT");
        String id = this.input.ask("input id item:");
        String name = this.input.ask("input new name:");
        String desc = this.input.ask("input new description:");
        this.tracker.edit(id, name, desc);
        this.checkAnswer();
    }

    /**
     * метод поиска заявки по id
     */
    public void findById() {
        this.countWrong = 0;
        System.out.println("You selection FIND_BY_ID");
        String id = this.input.ask("input id item:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.print("id: " + item.getId() + ". ");
            System.out.print("Name: " + item.getName() + ". ");
            System.out.print("Description: " + item.getDescription() + ". ");
            System.out.print("Date create: " + item.getCreate() + ".\n");
            this.checkAnswer();
        } else {
            System.out.println("По данному id: " + id + " заявок не найдено");
            this.checkAnswer();
        }

    }

    /**
     * метод поиска заявок по имени
     */
    public void finfByName() {
        this.countWrong = 0;
        System.out.println("You selection FIND_BY_NAME");
        String name = this.input.ask("input name:");
        Item[] items = tracker.findByName(name);
        this.showAll(items);
    }

    /**
     * метод проверки корректности ввода номера команд
     */
    private void wrongMenu() {
        this.countWrong++;
        if (countWrong < 3) {
            System.out.println("Вы выбрали неверный пункт меню, введите корректный");
            this.checkAnswer();
        } else {
            System.out.println("Вы три раза ввели неверный номер команды");
            this.exit();
        }
    }

    /**
     * Метод обработки введеных команд меню
     * @param answer - номер команды введенной пользователем
     */
    public void executeMenu(String answer) {
        if (ADD.equals(answer)) {
            this.add();
        } else if (SHOW_ALL.equals(answer)) {
            Item[] items = this.tracker.getAll();
            this.showAll(items);
        } else if (DELETE.equals(answer)) {
            this.remove();
        } else if (EDIT.equals(answer)) {
            this.edit();
        } else if (FIND_BY_ID.equals(answer)) {
            this.findById();
        } else if (FIND_BY_NAME.equals(answer)) {
            this.finfByName();
        } else if (EXIT.equals(answer)) {
            this.exit();
        } else {
            this.wrongMenu();
        }
    }

    /**
     * метод вывода диалогового меню с дальнейшей обработкой введенных команд
     */
    public void startProgr() {
        StringBuilder menu = new StringBuilder();
        String ln = System.lineSeparator();
        menu.append("-----------MENU--------" + ln);
        menu.append("0: ADD" + ln + "1: SHOW_ALL" + ln + "2: EDIT" + ln + "3: DELETE" + ln);
        menu.append("4: FIND_BY_ID" + ln + "5: FIND_BY_NAME" + ln + "6: EXIT" + ln);
        menu.append("-----------------------" + ln);
        System.out.println(menu);
        String answer = this.input.ask("Select the desired menu item:");
        executeMenu(answer);
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).startProgr();
    }
}
