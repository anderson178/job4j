package ru.job4j.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 18.01.2019
 */

public class CertificateTest {
    @Test
    public void levelOfWhenScopeMoreThree() {
        Certificate cert = new Certificate();
        List<Student> temp = List.of(
                new Student("Petr", 4),
                new Student("Denis", 2),
                new Student("Dmitry", 5),
                new Student("Vasily", 3)
                );
        List<Student> result = cert.levelOf(temp, 3);
        List<Student> expect = new ArrayList<>(Arrays.asList(temp.get(2), temp.get(0)));
        assertThat(result, is(expect));
    }

    @Test
    public void levelOfWhenScopeMoreTwo() {
        Certificate cert = new Certificate();
        List<Student> temp = List.of(
                new Student("Petr", 4),
                new Student("Denis", 2),
                new Student("Dmitry", 5),
                new Student("Vasily", 3)
        );
        List<Student> result = cert.levelOf(temp, 2);
        List<Student> expect = new ArrayList<>(Arrays.asList(temp.get(2), temp.get(0), temp.get(3)));
        assertThat(result, is(expect));
    }

    @Test
    public void levelOfWhenScopeMoreTwoAndExistNull() {
        Certificate cert = new Certificate();
        List<Student> temp = new ArrayList<>(Arrays.asList(
                new Student("Petr", 4),
                new Student("Denis", 2),
                new Student("Dmitry", 5),
                null,
                new Student("Vasily", 3),
                null
        ));
        List<Student> result = cert.levelOf(temp, 2);
        List<Student> expect = new ArrayList<>(Arrays.asList(temp.get(2), temp.get(0), temp.get(4)));
        assertThat(result, is(expect));
    }
}
