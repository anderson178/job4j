package ru.job4j.converter;
/**
 * Корвертор валюты.
 */
public class Converter {
    /**
     *@dollarkurs - курс доллара.
     *@evrokurs - курс евро.
     */
    private int dollarkurs = 60;
    private int evrokurs = 70;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / evrokurs);
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return (value / dollarkurs);
    }
    /**
     * Конвертируем евро в рубли.
     * @param value вевро.
     * @return рубли.
     */
    public int euroToRubli(int value) {
        return (value * evrokurs);
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */
    public int dollarToRubli(int value) {
        return (value  * dollarkurs);
    }
}
