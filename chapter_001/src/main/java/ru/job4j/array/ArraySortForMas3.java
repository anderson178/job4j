package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 16.08.2018
 */

public class ArraySortForMas3 {
    /**
     *  метод объединения двух массивов в один отсортированный
     * @param masA
     * @param masB
     * @return
     */
    public int[] sortMas3(int[] masA, int[] masB) {
        int lengthMasAB = masA.length + masB.length;
        int[] masC = new int[lengthMasAB];
        int masACount = 0;
        int masBCount = 0;
            for (int j = 0; j < masC.length; j++) {
                if ((masACount != masA.length) && (masBCount != masB.length)) {
                    if (masA[masACount] < masB[masBCount]) {
                        masC[j] = masA[masACount];
                        masACount++;
                    } else {
                        masC[j] = masB[masBCount];
                        masBCount++;
                    }
                } else if (masACount == masA.length) {
                    masC[j] = masB[masBCount];
                    masBCount++;
                } else {
                    masC[j] = masA[masACount];
                    masACount++;
                }
        }
        return masC;
    }
}
