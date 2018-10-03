package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 03.10.2018
 */
public class ConvertList {
    /**
     * метод конвертирующий коллекцию массивов типа int в одну коллекцию
     *
     * @param inList - коллекция массивов
     * @return коллекция
     */
    public List<Integer> convert(List<int[]> inList) {
        List<Integer> list = new ArrayList<>();
        for (int[] number : inList) {
            for (int number2 : number) {
                list.add(number2);
            }
        }
        return list;
    }
}
