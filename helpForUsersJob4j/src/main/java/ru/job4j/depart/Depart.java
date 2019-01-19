package ru.job4j.depart;

public class Depart implements Comparable<Depart> {
    protected String name;
    protected String path;
    public String[] names;
    protected String number;

    public Depart(String path) {

        String[] names = path.split("\\\\");
        this.names = names;
        this.name = names[names.length - 1];
        this.path = path;
        this.number = "" + (names[0].charAt(names[0].length() - 1));
        if (names.length > 1) {
            for (int i = 1; i < names.length; i++) {
                this.number += names[i].charAt(names[i].length() - 1);
            }
        } else {
            this.number = "" + names[0].charAt(names.length);
        }

    }

    public int compareTo(Depart o1) {
        // if (this.number>o1.number)
        return 1;
    }

}
