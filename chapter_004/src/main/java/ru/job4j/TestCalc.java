package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestCalc {
    private List<Double> linFunction(int start, int end, Function<Double, Double> func) {
        List<Double> rst = new ArrayList<>();
        for (int x = start; x != end; x ++) {
            rst.add(func.apply(Double.valueOf(x)));
        }
        return rst;
    }

    public static void main(String[] args) {
        TestCalc tc = new TestCalc();
        List<Double> list = new ArrayList<>();
        list.addAll(tc.linFunction(1, 10, (x) -> 2*x+4));
        int p =0;
    }
}
