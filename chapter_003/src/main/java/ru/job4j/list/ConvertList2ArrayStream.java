package ru.job4j.list;

import java.util.List;

public class ConvertList2ArrayStream {

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

    public static void main(String[] args) {

    }
}
