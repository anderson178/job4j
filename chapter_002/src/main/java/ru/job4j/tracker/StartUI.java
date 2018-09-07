package ru.job4j.tracker;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.09.2018
 */

public class StartUI {
    private Tracker tracker;
    private Input input;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            System.out.println("-----------MENU--------");
            menu.show();
            System.out.println("-----------------------");
            int key = Integer.valueOf(input.ask("select: "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("exit ?")));
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
