package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 15.08.2018
 */

public class ArraySortForMas3 {
    public int[] sortMas3 (int[] masA, int[] masB) {
        int lengthMasAB = masA.length + masB.length;
        int[] masC = new int [lengthMasAB];
        //int j = 1;
        int masACount = 0;
        int masBCount = 0;
        int masCCount = 0;

            for (int j = 0; j < masC.length; j++) {
                if ((masACount != masA.length) && (masBCount != masB.length)) {


                    if (masA[masACount] < masB[masBCount]) {
                        masC[masCCount] = masA[masACount];
                        masACount++;
                        masCCount++;


                    } else {

                        masC[masCCount] = masB[masBCount];
                        masBCount++;
                        masCCount++;
                        //j--;
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
