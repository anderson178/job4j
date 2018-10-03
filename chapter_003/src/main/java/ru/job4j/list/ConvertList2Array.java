package ru.job4j.list;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.10.2018
 */

public class ConvertList2Array {
    /**
     * Перевод объект list в двухмерный массив, остаточные элементы заполняются нулями
     *
     * @param list - list с значениями
     * @param rows - кол-во необходимых строк
     * @return - двухмерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int temp = list.size() % rows == 0 ? 0 : 1;
        int collumns = list.size() / rows + temp;
        int count = 0;
        int[][] mass = new int[rows][collumns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns && count != list.size(); j++) {
                mass[i][j] = list.get(count++);
            }
        }
        return mass;
    }
}
