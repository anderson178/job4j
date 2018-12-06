package ru.job4j.tracker;

import java.util.function.Consumer;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker, Consumer<String> show);
    String info();
}
