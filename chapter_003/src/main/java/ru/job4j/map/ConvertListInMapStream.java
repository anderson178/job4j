package ru.job4j.map;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.01.2019
 */

public class ConvertListInMapStream {

    public HashMap<Integer, User2> convert(List<User2> list) {
        return new HashMap<>(list.stream().collect(Collectors.toMap(User2::getId, User2 -> User2)));
    }
}
