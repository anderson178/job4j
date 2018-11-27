package ru.job4j;

import java.util.ArrayList;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionRange {

    public interface Operation {
        double calc(int value, int k, int a);
    }
/*
   public List<Integer> diapason(int start, int end, Function<Integer, Integer> func) {
        //y = kx + a
        List<Integer> rst = new ArrayList<>();
        //rst.remo
        for (int x = start; x <= end; x++) {
            func.apply()
            media.accept(op.apply());
            rst.add(op.calc(x, k, a));
            System.out.println(rst.get(x).toString());
        }
        return rst;
    }


    public static void main(String[] args) {
        FunctionRange fr = new FunctionRange();
        List<Double> list =  fr.diapason(0, 10,
                (start, end, er) -> { double result = start * end;
        return  result;}
        );
        int y =0;
    }*/
}
