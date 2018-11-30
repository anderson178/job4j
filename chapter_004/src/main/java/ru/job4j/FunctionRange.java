package ru.job4j;

import java.util.ArrayList;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionRange {

    public List<Double> function(int start, int end, Function<Double, Double> func) {
        List<Double> rst = new ArrayList<>();
        for (int x = start; x != end; x++) {
            rst.add(func.apply(Double.valueOf(x)));
        }
        return rst;
    }

}
