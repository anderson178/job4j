package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.09.2018
 */

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private String ln = System.lineSeparator();
    private ArrayList<UserAction> listActions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.listActions.size();
    }

    /**
     * Метод заполнения меню.
     */
    public void fillActions() {
        this.listActions.add(new AddItem(0, "ADD"));
        this.listActions.add(new ShowAllItem(1, "SHOW_ALL"));
        this.listActions.add(new EditItem(2, "EDIT"));
        this.listActions.add(new DeleteItem(3, "DELETE"));
        this.listActions.add(new FindByIdItem(4, "FIND_BY_ID"));
        this.listActions.add(new FinfByNameItem(5, "FIND_BY_NAME"));
        this.listActions.add(new Exit(6, "EXIT"));
    }

    /**
     * метод выполнения команды меню по заданному ключу
     *
     * @param key
     */
    public void select(int key) {
        this.listActions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Вывод меню
     */
    public void show() {
        for (UserAction action : this.listActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Общий метод для вывода списка данных запроса
     *
     * @param items - массив заявок
     */
    private void showAllItems(Item[] items) {
        if (items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.print("id: " + items[i].getId() + ". ");
                System.out.print("Name: " + items[i].getName() + ". ");
                System.out.print("Description: " + items[i].getDescription() + ". ");
                System.out.print("Date create: " + items[i].getCreate() + ln);
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    /**
     * внутренний класс для додавбления новой заявки
     */
    private class AddItem implements UserAction {
        private int key;
        private String action;

        private AddItem(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println();
            String name = input.ask("Please enter the task name: ");
            String desc = input.ask("Please enter the task description: ");
            tracker.add(new Item(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key, this.action);
        }
    }

    /**
     * внутренний класс для вывода массива запрашиваемых заявок
     */
    private class ShowAllItem implements UserAction {
        private int key;
        private String action;

        private ShowAllItem(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.getAll();
            System.out.println("You selection SHOW_ALL");
            showAllItems(items);
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key, this.action);
        }
    }

    /**
     * внутренний класс для редактирования заявок
     */
    private class EditItem implements UserAction {
        private int key;
        private String action;

        private EditItem(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection EDIT");
            String id = input.ask("input id item:");
            String name = input.ask("input new name:");
            String desc = input.ask("input new description:");
            Item item = new Item(name, desc);
            if (tracker.edit(id, item)) {
                System.out.println("Item is update");
            } else {
                System.out.println("Item with id: " + id + " not found");
            }
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key, this.action);
        }
    }

    /**
     * внутренний класс для удаления заявок
     */
    private class DeleteItem implements UserAction {
        private int key;
        private String action;

        private DeleteItem(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection DELETE");
            String id = input.ask("input id item:");
            if (tracker.remove(id)) {
                System.out.println("Item remove");
            } else {
                System.out.println("Item not found");
            }
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key, this.action);
        }
    }

    /**
     * внутренний класс для поиска заявки по id
     */
    private class FindByIdItem implements UserAction {
        private int key;
        private String action;

        private FindByIdItem(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        private String toStringItem(String id, String name, String desc, String create) {
            return String.format("Item id: %s, Name: %s, Description: %s Create: %s", id, name, desc, create);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection FIND_BY_ID");
            String id = input.ask("input id item:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(toStringItem(item.getId(), item.getName(), item.getDescription(), item.getCreate()));
            } else {
                System.out.println("По данному id: " + id + " заявок не найдено");
            }
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key, this.action);
        }
    }

    /**
     * внутренний класс для поиска заявок по имени
     */
    private class FinfByNameItem implements UserAction {
        private int key;
        private String action;

        private FinfByNameItem(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection FIND_BY_NAME");
            String name = input.ask("input name:");
            Item[] items = tracker.findByName(name);
            showAllItems(items);
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key, this.action);
        }
    }

    /**
     * внутренний класс для выхода из программы
     */
    private static class Exit implements UserAction {
        private int key;
        private String action;

        private Exit(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection EXIT");
            System.out.println("Goode bye");
            System.exit(0);
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key, this.action);
        }
    }

}