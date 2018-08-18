package ru.job4j.converter;

/**
 * конвертер Валюты
 * @author Denis Mironenko
 * @version $Id$
 * @since 18.08.2018
 */

public class Converter {
    /**
     *dollarkurs - курс доллара.
     *evrokurs - курс евро.
     */
    private int dollarKurs = 60;
    private int evroKurs = 70;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / evroKurs);
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return (value / dollarKurs);
    }
    /**
     * Конвертируем евро в рубли.
     * @param value вевро.
     * @return рубли.
     */
    public int euroToRubli(int value) {
        return (value * evroKurs);
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */
    public int dollarToRubli(int value) {
        return (value  * dollarKurs);
    }
}
