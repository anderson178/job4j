package ru.job4j.sortnumbertwo;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.01.2019
 */

public class ListSortedStream {

    public List<Users> sortNameLength(List<Users> listUsers) {
        return listUsers.stream().sorted(Comparator.comparing(Users::getLengthName)).collect(Collectors.toList());
    }

    public List<Users> sortNameAge(List<Users> listUsers) {
        return listUsers.stream().sorted(Comparator.comparing(Users::getName).thenComparing(Users::getAge)).collect(Collectors.toList());
    }
}
