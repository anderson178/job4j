package ru.job4j.depart;

public class Depart implements Comparable<Depart> {
    public Depart(String path) {
        String[] names = path.split("\\\\");
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
        int result = 0;
        int number1 = this.number.length();
        int number2 = o1.number.length();
        //System.out.println("\n" + number1 +"  " + this.path);
        int maxresult = number1 < number2 ? number1 : number2;
        if (number1 == number2) {
            for (int i = 0; i < maxresult; i++) {
                if (this.number.toCharArray()[i] < o1.number.toCharArray()[i]) {
                    result = 1;
                    break;
                } else {
                    result = -1;
                    break;
                }

            }
        } else {
            result = number1 < number2 ? 1 : -1;
        }


        return result;
    }

    protected String path;
    protected String number;

}
