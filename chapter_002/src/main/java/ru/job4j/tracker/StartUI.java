package ru.job4j.tracker;

//import com.sun.glass.ui.Menu;

public class StartUI {

    private static String menu = "0: ADD\n1: SHOW_ALL\n2: EDIT\n3: DELETE\n4: FIND_BY_ID\n5: FIND_BY_NAME\n6: EXIT\n ------------------ ";
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private Tracker tracker = new Tracker();
    private Item[] items;
    private ConsoleInput input = new ConsoleInput();

    private void checkAnswer() {
        ConsoleInput input = new ConsoleInput();
        String answer = input.ask("Do you want to continue working in the tracker? (y/n)");
        if (answer.equals("y")) {
            startProgr();
        } else {
            System.out.println("Goode bye");
        }
    }
    public void add () {
        System.out.println("You selection ADD" );
        String name = this.input.ask("input name Item");
        String desc = input.ask("input description");
        this.tracker.add(new Item (name,desc));
        System.out.println("Item create" );
        this.checkAnswer();
    }

    public void showAll() {
        Item[] items = this.tracker.getAll();
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
    public void remove() {
        System.out.println("You selection DELETE" );
        String id = this.input.ask("input id item:");
        this.tracker.remove(id);
        System.out.println("Item remove");
        this.checkAnswer();
    }

    public void executeMenu(String answer) {
        if (answer.equals(ADD)) {
            this.add();
            this.checkAnswer();
        } else if (answer.equals(SHOW_ALL)) {
            this.showAll();
            this.checkAnswer();
        } else if (answer.equals(DELETE)) {
            this.remove();
            this.checkAnswer();
        } else {
            System.out.println("Вы выбрали неверный пункт меню, введите корректный");
        }
    }

    public void startProgr() {
        System.out.println(menu);
        String answer = this.input.ask("Select the desired menu item:");
        executeMenu(answer);
    }

    public static void main(String[] args) {
        StartUI start = new StartUI();
        start.startProgr();
    }
}
