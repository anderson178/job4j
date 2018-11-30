package ru.job4j;

import java.util.ArrayList;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 30.11.2018
 */

public class FunctionRange {
    /**
     *
     * @param start - begin to range
     * @param end - end to range
     * @param func - calculation function
     * @return - list of the calculation range function
     */
    public List<Double> function(int start, int end, Function<Double, Double> func) {
        List<Double> rst = new ArrayList<>();
        for (int x = start; x != end; x++) {
            rst.add(func.apply(Double.valueOf(x)));
        }
        return rst;
    }

}
