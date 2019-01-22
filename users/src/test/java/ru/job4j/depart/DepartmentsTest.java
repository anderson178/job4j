package ru.job4j.depart;

import org.junit.Test;

public class DepartmentsTest {
    @Test
    public void sortdepUp() {
        Departments dep = new Departments();
        Depart[] departs = dep.checklength();
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < departs.length; i++) {
                int number1 = departs[i].number.length();
                int number2 = departs[i - 1].number.length();
                int maxresult = number1 < number2 ? number1 : number2;
                if (number1 == number2) {
                    for (int j = 0; j < maxresult; j++) {
                        if (departs[i].number.toCharArray()[j] < departs[i - 1].number.toCharArray()[j]) {
                            Depart c = departs[i];
                            departs[i] = departs[i - 1];
                            departs[i - 1] = c;
                            isSorted = false;
                            break;
                        }
                    }
                } else {
                    int count = 0;
                    for (int j = 0; j < maxresult; j++) {
                        if (departs[i].number.toCharArray()[j] > departs[i - 1].number.toCharArray()[j]) {
                            count = 0;
                            break;
                        } else if (departs[i].number.toCharArray()[j] == departs[i - 1].number.toCharArray()[j] && number1 < number2) {
                            count++;
                        }
                    }
                    if (count == maxresult && number1 < number2) {
                        Depart c = departs[i - 1];
                        departs[i - 1] = departs[i];
                        departs[i] = c;
                        isSorted = false;
                    }

                }
            }
        }
        for (Depart c : departs) {
            System.out.println("\n" + c.path + " " + c.number);
        }

    }
}
