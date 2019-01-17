package ru.job4j.ip;

import java.util.ArrayList;
import java.util.List;

public class RangeIP {

    private List<Integer> raznica(int start, int end) {
        List<Integer> rst = new ArrayList<>();

        if (start != end) {
            for (int i = start; i <= end; i++) {
                rst.add(i);
            }
        } else {
            rst.add(start);
        }

        return rst;
    }

    private List<String> calculation(List<List<Integer>> list) {
        List<String> ip = new ArrayList<>();
        for (Integer one : list.get(0)) {
            for (Integer two : list.get(1)) {
                for (Integer three : list.get(2)) {
                    for (Integer four : list.get(3)) {
                        ip.add(one.toString() + "." + two.toString() + "." + three.toString() + "." + four.toString());
                    }
                }
            }
        }
        return ip;
    }

    public List<String> range(String start, String end) {
        List<String> rst = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        String[] startMas = start.split("\\.");
        String[] endMas = end.split("\\.");
        for (int i = 0; i < startMas.length; i++) {
            list.add(this.raznica(Integer.parseInt(startMas[i]), Integer.parseInt(endMas[i])));
        }
        return calculation(list);
    }
}
