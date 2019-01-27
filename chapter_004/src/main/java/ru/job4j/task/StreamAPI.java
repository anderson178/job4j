package ru.job4j.task;

import java.util.Arrays;

public class StreamAPI {

    public static Integer calculate(Integer[] mas) {
        return Arrays.stream(mas)
                .filter(value -> value % 2 == 0)
                .map(value -> value * value)
                .reduce((left, right) -> left + right)
                .orElse(null);
    }
}
