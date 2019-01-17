package ru.job4j.school;

import org.junit.Test;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CertificateTest {
    @Test
    public void sertificateTest() {
        Certificate cert = new Certificate();
        List<Student> temp = new ArrayList<>();
        temp.add(new Student("Petr", 4));
        temp.add(new Student("Denis", 2));
        temp.add(new Student("Dmitry", 5));
        temp.add(new Student("Vasily", 3));
        List<Student> result = cert.levelOf(temp, 5);
        int p=0;
    }
}
