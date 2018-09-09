package ru.job4j.tracker;
import java.util.ArrayList;

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
        ArrayList<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            System.out.println("-----------MENU--------");
            menu.show();
            System.out.println("-----------------------");
            int key = Integer.valueOf(input.ask("select: ", range));
            menu.select(key);
        } while (!"y".equals(this.input.ask("exit ?")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
