package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.09.2018
 */

public class StartUI {
    private Tracker tracker;
    private Input input;
    private int key;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной метод для инициалазии программы
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            System.out.println("-----------MENU--------");
            menu.show();
            System.out.println("-----------------------");
            this.key = (input.ask("select: ", menu.fillRange()));
            menu.select(key);
            if (this.key == 6) {
                break;
            }
        } while (!"y".equals(this.input.ask("exit ?")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
