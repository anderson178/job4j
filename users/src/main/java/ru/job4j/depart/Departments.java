package ru.job4j.depart;

public class Departments {
    String[] depat1 = new String[7];
    String[] pulledDeps = pulldep();
    String check = "";
    int counterDepsnames = 0, lengthdepart = 0;
    int counterDepart = 0;

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

    //ВЫЧИСЛЯЕМ ДЛИННУ МАССИВА ИМЕН
    public Depart[] checklength() {
        for (int i = 1; i < pulledDeps.length; i++) {
            if (pulledDeps[i].split("\\\\").length > pulledDeps[i - 1].split("\\\\").length) {
                check = pulledDeps[i];
            }
        }


        Depart[] depsnames = new Depart[pulledDeps.length * check.split("\\\\").length];

        //ЗАПОЛНЯЕМ МАССИВ НЕУНИКАЛЬНЫМИ ДЕПАРТАМЕНТАМИ
        for (int i = 0; i < pulledDeps.length; i++) {
            for (int j = 0; j < pulledDeps[i].split("\\\\").length; j++) {
                String path = "";
                for (int x2 = 0; x2 < pulledDeps[i].split("\\\\").length - j; x2++) {
                    path += pulledDeps[i].split("\\\\")[x2] + "\\";
                }
                depsnames[counterDepsnames++] = new Depart(path);
            }
        }

        //ЗАПОЛНЯЕМ УНИКАЛЬНЫМИ ДЕПАРТАМЕНТАМИ
        for (int i = 0; i < depsnames.length; i++) {
            for (int j = i + 1; j < depsnames.length; j++) {
                if (depsnames[i] != null && depsnames[j] != null && depsnames[i].number.equals(depsnames[j].number)) {
                    depsnames[j] = null;
                    lengthdepart++;
                }
            }
        }


        //УБИРАЕМ НУЛЕВЫЕ ЭЛЕМЕНТЫ
        Depart[] depart = new Depart[lengthdepart + 1];
        for (Depart c : depsnames) {
            if (c != null) {
                depart[counterDepart++] = c;
            }
        }
        return depart;
    }
}
