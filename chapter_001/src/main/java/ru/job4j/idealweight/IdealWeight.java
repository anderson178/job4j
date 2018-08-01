package ru.job4j.idealweight;
/**
 *clas IdealWeight
 *@author Denis Mironenko
 *@since 1.08.2018
 *@version 1.0
 */
public class IdealWeight {
    /**
     * @param indexforman - индекс для мужчин.
     * @param indexforwoman - индекс для женщин.
     * @param generalindex - общий индекс
     */
    private int indexforman = 100;
    private int indexforwoman = 110;
    private double generalindex = 1.15;

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return ((height - indexforman) * generalindex);
    }

    public double womanWeight(double height) {
        return ((height - indexforwoman) * generalindex);
    }
}
