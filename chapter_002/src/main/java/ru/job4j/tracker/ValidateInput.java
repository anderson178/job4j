package ru.job4j.tracker;

import java.util.ArrayList;

public class ValidateInput extends ConsoleInput {
        public int ask(String question, ArrayList<Integer> range) {
            boolean invalide = true;
            int value = -1;
            do {
                try {
                    value = super.ask(question, range);
                    invalide = false;
                } catch (MenuOutExeption moe) {
                    System.out.println("Enter number menu  of range");
                } catch (NumberFormatException nfe) {
                    System.out.println("Please inter validate data again");
                }
            }
            while (invalide);
            return value;
        }
}
