package ru.job4j.school;

import java.util.Comparator;
import java.util.List;

public class Certificate  {
    public  List<Student> levelOf(List<Student> students, int bound) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return o1.getBound().compareTo(o2.getBound());
            }
        });
        List<Student> rst = students;
        return rst;


    }
}
