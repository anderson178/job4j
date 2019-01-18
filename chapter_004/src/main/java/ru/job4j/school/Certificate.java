package ru.job4j.school;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 18.01.2019
 */

public class Certificate {
    /**
     * Method to sorted and generates new list with scope more than bound
     * @param students - list
     * @param bound - limit
     * @return - list when scope more than bounf
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable)
                .sorted((Student o1, Student o2) -> o2.getScope().compareTo(o1.getScope()))
                .takeWhile(value -> value.getScope() > bound)
                .collect(Collectors.toList());
    }
}
