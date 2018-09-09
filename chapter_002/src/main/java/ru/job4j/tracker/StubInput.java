package ru.job4j.tracker;

import java.util.ArrayList;

public class StubInput implements Input {
    private String[] answer;
    private int position = 0;

    public StubInput(String[] answer) {
        this.answer = answer;
    }

    public String ask(String questions) {
            return answer[position++];
    }
    public int ask(String question, ArrayList<Integer> range) {
        //throw new Exception("Nosupported operation");
    return -1;
    }
}
