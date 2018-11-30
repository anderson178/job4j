package ru.job4j.task;

import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 30.11.2018
 */

public class SortTreeSetDepartament {

    /**
     * Метод добавления массива департаметов в treeSet
     * @param line - строка депаратментов разбитая на массив
     * @param tree - коллекция treeSet с депаратментами
     */
    private void addDep(String[] line, TreeSet<String> tree) {
        StringBuilder rst = new StringBuilder();
        if (line.length > 1) {
            for (int j = 0; j < line.length; j++) {
                if (j != line.length - 1) {
                    rst.append(line[j]);
                    tree.add(rst.toString());
                    rst.append("\\");
                } else  {
                    rst.append(line[j]);
                    tree.add(rst.toString());
                }
            }
        } else {
            tree.add(line[0]);
        }
    }

    /**
     * Метод разбивает каждую строку на массивы и добавляет их в treeSet поэлементно
     * @param listDep - входящий список департаментов
     * @return - отсортированная коллекция с депаратментами по возрастанию
     */
    public TreeSet<String> sortUp(List<String> listDep) {
        TreeSet<String> rst = new TreeSet<>();
        for (String dep : listDep) {
            String[] temp = dep.split("\\\\");
            addDep(temp, rst);
        }
        return rst;
    }

    /**
     * Метод разбивает каждую строку на массивы и добавляет их в treeSet поэлементно
     * @param listDep - входящий список департаментов
     * @return - отсортированная коллекция с депаратментами по убыванию
     */
    public TreeSet<String> sortDown(List<String> listDep) {
        TreeSet<String> rst = new TreeSet<>(new SortComparator());
        for (String dep : listDep) {
            String[] temp = dep.split("\\\\");
            addDep(temp, rst);
        }
        return rst;
    }
}
