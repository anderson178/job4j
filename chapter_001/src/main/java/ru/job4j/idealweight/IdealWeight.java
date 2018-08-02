package ru.job4j.idealweight;
/**
 *clas IdealWeight
 *@author Denis Mironenko
 *@since 1.08.2018
 *@version 1.0
 */
public class IdealWeight {
    //@param indexforman - индекс для мужчин
    private int indexforman = 100;
    //@param indexforwoman - индекс для женщин
    private int indexforwoman = 110;
    //@param generalindex - общий индекс
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
