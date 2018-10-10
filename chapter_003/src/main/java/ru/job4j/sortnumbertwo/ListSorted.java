package ru.job4j.sortnumbertwo;

import java.util.Comparator;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.10.2018
 */
public class ListSorted {

    /**
     * метод сортировки коллекции по длине имени
     *
     * @param listUsers - коллекция объектов UserCmpr
     * @return
     */
    public List<Users> sortNameLength(List<Users> listUsers) {
        listUsers.sort(new Comparator<Users>() {
            @Override
            public int compare(Users o1, Users o2) {
                return o1.getLengthName().compareTo(o2.getLengthName());
            }
        });
        return listUsers;
    }

    /**
     * метод сортировки коллекции UserCmpr сперва по имени а если они равны то по годам
     *
     * @param listUsers - коллекция объектов UserCmpr
     * @return
     */
    public List<Users> sortNameAge(List<Users> listUsers) {
        listUsers.sort(new Comparator<Users>() {
            @Override
            public int compare(Users o1, Users o2) {
                int temp = o1.getName().compareTo(o2.getName());
                return temp == 0 ? o1.getAge().compareTo(o2.getAge()) : temp;
            }
        });
        return listUsers;
    }
}
