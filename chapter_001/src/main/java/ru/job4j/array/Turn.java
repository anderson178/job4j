package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.08.2018
 */

public class Turn {
    /**
     *
     * @param mas - входной массив
     * @return - перевернутый массив
     */
    public int[] turnMas(int[] mas) {
        int temp = 0;
        int sizeMas = mas.length;
        /**
         * что бы не проходить весь массив, делим его пополам и окргуляем до ближайшего
         * целого числа, что бы в случае нечетного кол-ва элементов
         * массива не трогать центральный элемент.
         */
            for (int i = 0; i < Math.floor(mas.length / 2); i++) {
                temp = mas[i];
                mas[i] = mas[sizeMas - 1];
                mas[sizeMas - 1] = temp;
                sizeMas--;
            }
        return mas;
    }
}
