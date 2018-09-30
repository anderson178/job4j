package ru.job4j.tracker;

import ru.job4j.ForMe;

public class ForYou extends ForMe {
    private int a,b;
    public ForYou(int a, int b){
        super(a,b);
        //this.a = a;
        //this.b = b;

    }

    public static void main(String[] args) {
        ForYou fy = new ForYou(3,4);
        System.out.println(fy.summ());
    }

}
