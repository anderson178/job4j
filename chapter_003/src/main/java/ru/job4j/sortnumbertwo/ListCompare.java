package ru.job4j.sortnumbertwo;

import java.util.Comparator;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.10.2018
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int sizeLeft = left.toCharArray().length;
        int sizeRight = right.toCharArray().length;
        int size = sizeLeft < sizeRight ? sizeLeft : sizeRight;
        int result = 0;
        int i = 0;
        for (i = 0; i < size; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                result = left.charAt(i) < right.charAt(i) ? 1 : -1;
                break;
            }
        }
        if (i == size && sizeLeft != sizeRight) {
            result = sizeLeft < sizeRight ? 1 : -1;
        }
        return result;
    }
}
