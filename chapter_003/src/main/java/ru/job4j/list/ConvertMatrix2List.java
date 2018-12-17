package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 03.10.2018
 */
public class ConvertMatrix2List {
    /**
     * метод перевода двухмерного массива в список
     *
     * @param array - двухмерный массив
     * @return - список
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] external : array) {
            for (int interrior : external) {
                list.add(interrior);
            }
        }
        return list;
    }

}
