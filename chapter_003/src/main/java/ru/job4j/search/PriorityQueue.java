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
        boolean temp = false;
        int size = this.tasks.size();
        if (this.tasks.size() != 0) {
            for (int i = 0; i < size; i++) {
                if (task.getPriority() < this.tasks.get(i).getPriority()) {
                    temp = true;
                    this.tasks.add(i, task);
                    break;
                }
            }
            if (!temp) {
                this.tasks.add(task);
            }
        } else {
            this.tasks.add(task);
        }
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
