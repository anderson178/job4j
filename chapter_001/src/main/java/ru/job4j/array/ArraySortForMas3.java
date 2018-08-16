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
    public int minNumber (int[] a , int[] b) {


    }

    public int[] sortMas3 (int[] masA, int[] masB) {
        int lengthMasAB = masA.length + masB.length;
        int[] masC = new int [lengthMasAB];
        //int j = 1;
        int masACount = 0;
        int masBCount = 0;
        int masCCount = 0;
        for (int  i = 0; i < masC.length; i++) {

            for (int j = 0; j < masA.length; j++) {
                if (masA[masACount] < masB[masBCount]) {
                    masC[masCCount] = masA[masACount];
                    masACount++;
                    masCCount++;


                } else {
                    masC[masCCount] = masB[masBCount];
                    masBCount++;
                    masCCount++;
                    j--;
                }
            }
        }
        return masC;
    }
}
