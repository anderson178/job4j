package ru.job4j.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 01.10.2018
 */
public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставки объекта task в список по полю приоритета
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = this.tasks.size();
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < this.tasks.get(i).getPriority()) {
                index = i;
                break;
            }
        }
        this.tasks.add(index, task);
    }

    /**
     * метод получения первого элемента в списке
     *
     * @return
     */
    public Task take() {
        return this.tasks.poll();
    }
}
