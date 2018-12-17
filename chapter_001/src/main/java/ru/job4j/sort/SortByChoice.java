package ru.job4j.sort;

public class SortByChoice {
    private int indexOut(int[] mas, int indexIn) {
        int cell = mas[indexIn];
        int indexOut = indexIn;
        for (int i = indexIn; i < mas.length - 1; i++) {
            if (cell > mas[i]) {
                indexOut = i;
            }
        }
        return indexOut;
    }

    private void swap(int[] mas, int first, int second) {
        int temp = mas[first];
        mas[first] = mas[second];
        mas[second] = temp;
    }

    public void sort(int[] mas) {
        int min;
        for (int i = 0; i < mas.length; i++) {
            min = indexOut(mas, i);
            if (mas[i] != mas[min]) {
                swap(mas, i, min);
            }
        }
    }
}
