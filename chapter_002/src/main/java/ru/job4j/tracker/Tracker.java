package ru.job4j.tracker;

import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.10.2018
 */

public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * метод генерации id для заявки
     *
     * @return
     */
    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * добавление новой заявки в трекер
     *
     * @param item - заявка
     * @return
     */
    public Item add(Item item) {
        String create = new Date().toString();
        item.setId(this.generatedId());
        item.setCreate(create);
        items.add(item);
        return item;
    }

    /**
     * выводит список всех заявок в трекере
     *
     * @return
     */
    public ArrayList<Item> getAll() {
        return this.items;
    }

    /**
     * заменяет существущую заявку на другую по id
     *
     * @param id - идентификатор заявки
     * @item - заявка
     */
    public boolean edit(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                item.setId(this.items.get(i).getId());
                item.setCreate(this.items.get(i).getCreate());
                this.items.set(i, item);
                result = true;
            }
        }

        return result;
    }

    /**
     * поиск заявки по id
     *
     * @param id - идентификатор заявки
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * метод поиска заявки по имени
     *
     * @param keyName - имя заявки
     * @return
     */
    public ArrayList<Item> findByName(String keyName) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(keyName)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * метод удаления заявки по id
     *
     * @param id - идентификатор заявки
     * @return
     */
    public boolean remove(String id) {
        boolean res = false;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                this.items.remove(item);
                res = true;
                break;
            }
        }
        return res;
    }
}
