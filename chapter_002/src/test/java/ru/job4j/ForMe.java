package ru.job4j;

public class ForMe {
    int v;
    int p;
    public ForMe(int v, int p) {
        this.v = v;
        this.p = p;
    }

    public int summ() {
        int c = v + p;
        return c;
    }

    public String summ(int a, int b, int d) {
        String sd = String.valueOf(a + b + d);
        return sd;
    }
   static int sd() {
        return 1 + 2;
   }

    public static void main(String[] args) {
        ForMe fm = new ForMe(2, 7);
        String f = fm.summ(2, 3, 4);
        System.out.println(f);
    }
}
