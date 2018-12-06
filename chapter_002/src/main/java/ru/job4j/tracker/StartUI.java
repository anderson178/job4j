package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.09.2018
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
    public void init(Consumer<String> menuShow) {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menuShow.accept("-----------MENU--------");
            menu.show(x -> System.out.println(x));
            menuShow.accept("-----------------------");
            int key = (input.ask("select: ", menu2 -> System.out.println(menu2), menu.fillRange()));
            menu.select(key);
        } while (this.work);
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init(menu -> System.out.println(menu));
    }
}
