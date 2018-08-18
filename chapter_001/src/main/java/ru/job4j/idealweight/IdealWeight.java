package ru.job4j.idealweight;
/**
 *clas IdealWeight
 *@author Denis Mironenko
 *@since 1.08.2018
 *@version 1.0
 */
public class IdealWeight {
    private int indexForMan = 100;
    private int indexForWoman = 110;
    private double generalIndex = 1.15;
    /**
     * ideal weight for mas.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return ((height - indexForMan) * generalIndex);
    }

    public double womanWeight(double height) {
        return ((height - indexForWoman) * generalIndex);
    }
}
