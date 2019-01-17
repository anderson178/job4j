package ru.job4j.school;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String name;
    private Integer bound;

    public Student(String name, Integer bound) {
        this.name = name;
        this.bound = bound;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getBound().compareTo(o1.getBound());
    }

    public Integer getBound() {
        return bound;
    }

    public String getName() {
        return name;
    }
}
