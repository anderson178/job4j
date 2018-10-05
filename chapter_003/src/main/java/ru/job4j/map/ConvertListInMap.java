package ru.job4j.map;

import java.util.HashMap;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 04.10.2018
 */

public class ConvertListInMap {
    /**
     * метод конвертирования списка объектов User в HashMap
     *
     * @param list - список объектов User
     * @return - hashMap
     */
    public HashMap<Integer, User> convert(List<User> list) {
        HashMap<Integer, User> rst = new HashMap<>();
        int id = 0;
        for (User user : list) {
            rst.put(user.getId(), user);
        }
        return rst;
    }
}
