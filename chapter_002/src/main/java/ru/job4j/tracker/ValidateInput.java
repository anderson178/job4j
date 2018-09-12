package ru.job4j.tracker;



import java.util.ArrayList;

public class ValidateInput implements ru.job4j.tracker.Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, ArrayList<Integer> range) {
        boolean invalide = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalide = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Enter number menu  of range");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        }
        while (invalide);
        return value;
    }
}
