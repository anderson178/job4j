package ru.job4j.array;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int sizeOut = list1.size() + list2.size();
        int sizeIn = list1.size() + list2.size();
        int list1Count = 0;
        int list2Count = 0;
        for (int j = 0; j < sizeOut; j++) {
            if ((list1Count != list1.size()) && (list2Count != list2.size())) {
                if (list1.get(list1Count) < list2.get(list2Count)) {
                    result.add(list1.get(list1Count));
                    list1Count++;
                } else {
                    result.add(list2.get(list2Count));
                    list2Count++;
                }
            } else if (list1Count == list1.size()) {
                result.add(list2.get(list2Count));
                list2Count++;
            } else {
                result.add(list1.get(list1Count));
                list1Count++;
            }
        }
        return result;
    }

    private List<List<Integer>> distribution(List<Integer> mas) {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        result.add(new ArrayList<>());
        for (int i = 0; i < mas.size() - 1; i++) {
            if (mas.get(i) <= mas.get(i + 1)) {
                result.get(count).add(mas.get(i));
            } else {
                result.get(count).add(mas.get(i));
                result.add(new ArrayList<>());
                count++;
            }
        }
        if (mas.get(mas.size() - 2) <= mas.get(mas.size() - 1)) {
            result.get(count).add(mas.get(mas.size() - 1));

        } else {
            result.add(new ArrayList<>());
            count++;
            result.get(count).add(mas.get(mas.size() - 1));
        }
        return result;
    }

    public void sort(List<Integer> mas) {

        List<List<Integer>> list1 = this.distribution(mas);
        List<Integer> temp = new ArrayList<>();
        while (list1.size() > 1) {
            for (int i = 0; i < list1.size(); i = i + 2) {
                if (list1.size() % 2 == 0) {
                    temp.addAll(this.merge(list1.get(i), list1.get(i + 1)));
                } else {
                    if (i == list1.size() - 1) {
                        temp.addAll(list1.get(list1.size() - 1));
                    } else {
                        temp.addAll(this.merge(list1.get(i), list1.get(i + 1)));
                    }
                }
            }
            list1 = this.distribution(temp);
            temp.clear();
        }
    }
}


