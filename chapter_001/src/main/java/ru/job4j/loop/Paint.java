package ru.job4j.loop;

public class Paint {

    public String rightTrl(int height) {
        StringBuilder screenright = new StringBuilder();
        String ln = System.lineSeparator();
        int weight = height;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < weight; column++) {
                screenright.append((row >= column) ? "^" : " ");
            }
            screenright.append(ln);
        }
        return screenright.toString();
    }

    public String leftTrl(int height) {
        StringBuilder screenright = new StringBuilder();
        String ln = System.lineSeparator();
        int weight = height;
        int indexWhiteSpaces = height - 1;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < weight; column++) {
                screenright.append((column >= indexWhiteSpaces) ? "^" : " ");
            }
            screenright.append(ln);
            indexWhiteSpaces--;
        }
        return screenright.toString();
    }
    public String piramid(int height) {
        StringBuilder screenright = new StringBuilder();
        String ln = System.lineSeparator();
        int weight = 2 * height - 1;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < weight; column++) {
                screenright.append((row >= height - column - 1 && row + height - 1 >= column) ? "^" : " ");
            }
            screenright.append(ln);
        }
        return screenright.toString();
    }
}
