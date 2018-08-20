package ru.job4j.profession;

/**
 * поле intervalClass указывает с какими классами работает учитель.
 * поле degree указывает степень (ученая и т.д.) учителя.
 */
public class Teacher extends Profession {
    private int intervalClass;
    private String degree;
    public int getIntervalClass() {
        return this.intervalClass;
    }
    public String getDegree() {
        return this.degree;
    }
}
