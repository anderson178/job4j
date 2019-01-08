package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.01.2019
 */

public class ConvertListStream {
    public List<Integer> convert(List<int[]> inList) {
        return inList.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }
}
