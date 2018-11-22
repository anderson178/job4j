package ru.job4j.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 22.11.2018
 */

public class MergeSort {

    /**
     * merge method of two lists
     * @param list1 - input first list
     * @param list2 - input second list
     * @return - merged sorted list
     */
    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int size = list1.size() + list2.size();
        int list1Count = 0;
        int list2Count = 0;
        for (int j = 0; j < size; j++) {
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

    /**
     * item distribution method by the lists
     * @param mas - input list
     * @return list of lists
     */
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

    /**
     * sorting method
     * @param mas - input list
     * @return - sorted list
     */
    public List<Integer> sort(List<Integer> mas) {
        List<List<Integer>> result = this.distribution(mas);
        List<Integer> temp = new ArrayList<>();
        while (result.size() > 1) {
            for (int i = 0; i < result.size(); i = i + 2) {
                if (result.size() % 2 == 0) {
                    temp.addAll(this.merge(result.get(i), result.get(i + 1)));
                } else {
                    if (i == result.size() - 1) {
                        temp.addAll(result.get(result.size() - 1));
                    } else {
                        temp.addAll(this.merge(result.get(i), result.get(i + 1)));
                    }
                }
            }
            result = this.distribution(temp);
            temp.clear();
        }
        return result.get(0);
    }
}


