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
    private boolean work = true;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * метод для смены флага способствующий остановке программы
     */
    public void stop() {
        this.work = false;
    }

    /**
     * Основной метод для инициалазии программы
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            System.out.println("-----------MENU--------");
            menu.show();
            System.out.println("-----------------------");
            int key = (input.ask("select: ", menu.fillRange()));
            menu.select(key);
        } while (this.work);
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
