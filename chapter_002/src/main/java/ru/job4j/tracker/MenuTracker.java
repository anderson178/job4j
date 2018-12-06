package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.10.2018
 */

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> listActions = new ArrayList<>();
    private ArrayList<Integer> range = new ArrayList<>();


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
    public void fillActions(StartUI ui) {
        this.listActions.add(new AddItem(0, "ADD"));
        this.listActions.add(new ShowAllItem(1, "SHOW_ALL"));
        this.listActions.add(new EditItem(2, "EDIT"));
        this.listActions.add(new DeleteItem(3, "DELETE"));
        this.listActions.add(new FindByIdItem(4, "FIND_BY_ID"));
        this.listActions.add(new FinfByNameItem(5, "FIND_BY_NAME"));
        this.listActions.add(new Exit(6, "EXIT", ui));
    }

    /**
     * Метод заполнения числового интервала меню
     *
     * @return - интервал от 0 до значения размера массива
     */
    public ArrayList<Integer> fillRange() {
        for (int i = 0; i < this.getActionsLentgh(); i++) {
            range.add(i);
        }
        return this.range;
    }


    /**
     * метод выполнения команды меню по заданному ключу
     *
     * @param key
     */
    public void select(int key) {
        this.listActions.get(key).execute(this.input, this.tracker, show -> System.out.println(show));
    }

    /**
     * Вывод меню
     */
    public void show(Consumer<String> menu) {
        for (UserAction action : this.listActions) {
            if (action != null) {
                menu.accept(action.info());
            }
        }
    }

    /**
     * Общий метод для вывода списка данных запроса
     *
     * @param items - массив заявок
     */
    private void showAllItems(ArrayList<Item> items, Consumer<String> show) {
        if (items.size() != 0) {
            for (Item item : items) {
                show.accept(item.toString());
            }
        } else {
            show.accept("Список пуст");
        }
    }

    /**
     * внутренний класс для додавбления новой заявки
     */
    private class AddItem extends BaseAction {

        private AddItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> show) {
            show.accept("You selection ADD");
            //System.out.println("You selection ADD");
            String name = input.ask("Please enter the task name: ", showName -> System.out.println(showName));
            String desc = input.ask("Please enter the task description: ", showDesc -> System.out.println(showDesc));
            tracker.add(new Item(name, desc));
            show.accept("Item create");
           // System.out.println("Item create");
        }

    }

    /**
     * внутренний класс для вывода массива запрашиваемых заявок
     */
    private class ShowAllItem extends BaseAction {

        private ShowAllItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> show2) {
            ArrayList<Item> items = tracker.getAll();
            show2.accept("You selection SHOW_ALL");
            //System.out.println("You selection SHOW_ALL");
            showAllItems(items, show -> System.out.println(show));
        }
    }

    /**
     * внутренний класс для редактирования заявок
     */
    private class EditItem extends BaseAction {

        private EditItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> show) {
            show.accept("You selection EDIT");
            //System.out.println("You selection EDIT");
            String id = input.ask("input id item:", showId -> System.out.println(showId));
            String name = input.ask("input new name:", showName -> System.out.println(showName));
            String desc = input.ask("input new description:", showDesc -> System.out.println(showDesc));
            Item item = new Item(name, desc);
            if (tracker.edit(id, item)) {
                show.accept("Item is update");
                //System.out.println("Item is update");
            } else {
                show.accept("Item with id: " + id + " not found");
                //System.out.println("Item with id: " + id + " not found");
            }
        }
    }

    /**
     * внутренний класс для удаления заявок
     */
    private class DeleteItem extends BaseAction {

        private DeleteItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> show) {
            show.accept("You selection DELETE");
           // System.out.println("You selection DELETE");
            String id = input.ask("input id item:", showId -> System.out.println(showId));
            if (tracker.remove(id)) {
                show.accept("Item remove");
                //System.out.println("Item remove");
            } else {
                show.accept("Item not found");
                //System.out.println("Item not found");
            }
        }

    }

    /**
     * внутренний класс для поиска заявки по id
     */
    private class FindByIdItem extends BaseAction {

        private FindByIdItem(int key, String action) {
            super(key, action);
        }

        private String toStringItem(String id, String name, String desc, String create) {
            return String.format("Item id: %s, Name: %s, Description: %s Create: %s", id, name, desc, create);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> show) {
            show.accept("You selection FIND_BY_ID");
            //System.out.println("You selection FIND_BY_ID");
            String id = input.ask("input id item:", showId -> System.out.println(showId));
            Item item = tracker.findById(id);
            if (item != null) {
                show.accept(toStringItem(item.getId(), item.getName(), item.getDescription(), item.getCreate()));
                //System.out.println(toStringItem(item.getId(), item.getName(), item.getDescription(), item.getCreate()));
            } else {
                show.accept("По данному id: " + id + " заявок не найдено");
                //System.out.println("По данному id: " + id + " заявок не найдено");
            }
        }
    }

    /**
     * внутренний класс для поиска заявок по имени
     */
    private class FinfByNameItem extends BaseAction {

        private FinfByNameItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> show2) {
            show2.accept("You selection FIND_BY_NAME");
            //System.out.println("You selection FIND_BY_NAME");
            String name = input.ask("input name:", showName -> System.out.println(showName));
            ArrayList<Item> items = tracker.findByName(name);
            showAllItems(items, show -> System.out.println(show));
        }
    }

    /**
     * внутренний класс для выхода из программы
     */
    private static class Exit extends BaseAction {
        private final StartUI ui;

        public Exit(int key, String action, StartUI ui) {
            super(key, action);
            this.ui = ui;
        }

        public void execute(Input input, Tracker tracker, Consumer<String> show) {
            show.accept("You selection EXIT");
            show.accept("Goode bye");
            //System.out.println("You selection EXIT");
            //System.out.println("Goode bye");
            this.ui.stop();
        }
    }

}
