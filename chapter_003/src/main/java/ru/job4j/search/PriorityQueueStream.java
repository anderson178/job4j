package ru.job4j.search;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.01.2019
 */

public class PriorityQueueStream {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставки объекта task в список по полю приоритета
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = this.tasks.size();
        Optional<Integer> indexTemp = IntStream.range(0, this.tasks.size()).filter(i -> task.getPriority() < this.tasks.get(i).getPriority()).boxed().findFirst();
        if (indexTemp.isPresent()) {
            index = indexTemp.get();
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
