package ru.job4j.depart;

import org.junit.Test;

public class DepartmentsTest {
    @Test
    public void sortdepUp() {
        Departments dep = new Departments();
        String[] pulledDeps = dep.pulldep();
        Depart[] depart = new Depart[50];
        String check = "";
        int x = 0;
        //ВЫЧИСЛЯЕМ ДЛИННУ МАССИВА ИМЕН
        for (int i = 1; i < pulledDeps.length; i++) {
            if (pulledDeps[i].split("\\\\").length > pulledDeps[i - 1].split("\\\\").length) {
                check = pulledDeps[i];
            }
        }
        //ЗАПОЛНЯЕМ МАССИВ ДЕПАРТАМЕНТОВ
        Depart[] depsnames = new Depart[pulledDeps.length * check.split("\\\\").length];

        //ЗАПОЛНЯЕМ МАССИВ НЕУНИКАЛЬНЫМИ ДЕПАРТАМЕНТАМИ
        for (int i = 0; i < pulledDeps.length; i++) {
            for (int j = 0; j < pulledDeps[i].split("\\\\").length; j++) {
                String path = "";
                for (int x2 = 0; x2 < pulledDeps[i].split("\\\\").length - j; x2++) {
                    path += pulledDeps[i].split("\\\\")[x2] + "\\";
                }
                depsnames[x++] = new Depart(path);
            }
        }

        //ЗАПОЛНЯЕМ УНИКАЛЬНЫМИ ДЕПАРТАМЕНТАМИ
        for (int i = 0; i < depsnames.length; i++) {
            for (int j = i + 1; j < depsnames.length; j++) {
                if (depsnames[i] != null && depsnames[j] != null && depsnames[i].number.equals(depsnames[j].number)) {
                    System.out.println("УДАЛЕНО : " + depsnames[j].name + " " + depsnames[j].number + " дубликат к " + depsnames[i].name + " " + depsnames[i].number);
                    depsnames[j] = null;
                }

            }
        }


        //ПЕЧАТЬ ИМЕН
        System.out.println("ЭТО ТВОЯ ДЛИННА = " + depsnames.length + " ЭТО ТВОЯ ДЛИННА = " + check.split("\\\\").length);
        for (int p = 0; p < depsnames.length; p++) {
            if (depsnames[p] != null) {
                System.out.println(depsnames[p].name);
            }
        }
    }
}
