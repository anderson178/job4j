package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 15.08.2018
 */

public class ArraySortForMas3 {

    /**
     * метод получения нового объединенного отсортированного массива
     * @param masA - первый отсортированный массив
     * @param masB - второй остортированный массив
     * @return - объединенный отсортированный массив
     */
    public int[] sortMas3 (int[] masA, int[] masB) {
        int lengthMasAB = masA.length + masB.length;
        int[] masC = new int [lengthMasAB];
        int j = 0;
        for (int  i = 0; i < masA.length; i++) {
            if (masA[i] < masB[i]) {
                masC[j] = masA[i];
                masC[j+1] = masB[i];
            } else {
                masC[j] = masB[i];
                masC[j+1] = masA[i];
            }
            j = j + 2;
        }
        return masC;
    }
}
