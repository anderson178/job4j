package ru.job4j.depart;

public class Departments {
    String[] depat1 = new String[7];
    public String[] pulldep() {
        depat1[0] = "K1\\SK1";
        depat1[1] = "K1\\SK1\\SSK1";
        depat1[2] = "K1\\SK1\\SSK2";
        depat1[3] = "K1\\SK2";
        depat1[4] = "K2\\";
        depat1[5] = "K2\\SK1\\SSK1";
        depat1[6] = "K2\\SK1\\SSK2";
        return depat1;
    }
}
