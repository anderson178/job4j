package ru.job4j.school;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String name;
    private Integer scope;

    public Student(String name, Integer scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    public Integer getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }
}
