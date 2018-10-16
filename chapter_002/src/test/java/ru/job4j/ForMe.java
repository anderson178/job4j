package ru.job4j;

import java.util.ArrayList;

public class ForMe {
    private int v;
    private int p;
    public ForMe(int v, int p) {
        this.v = v;
        this.p = p;
    }

    public int summ() {
        int c = v + p;
        return c;
    }

    public String summ(int a, int b, int d, ForMe s) {
        String sd = String.valueOf(a + b + d);
        s.p = 12;
        return sd;
    }
   static int sd() {
        return 1 + 2;
   }

    public static void main(String[] args) {
        Object  o = new Object();
        ForMe m = (ForMe) o;
        /*ForMe fm = new ForMe(2, 7);
        String f = fm.summ(2, 3, 4);
        ArrayList<String> words = new ArrayList<>();
        words.add("asdas");
        words.add("erer");*/
        System.out.println(m);
    }
}
