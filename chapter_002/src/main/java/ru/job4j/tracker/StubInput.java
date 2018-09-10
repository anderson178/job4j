package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.09.2018
 */

public class StubInput implements Input {
    private String[] answer;
    private int position = 0;

    public StubInput(String[] answer) {
        this.answer = answer;
    }

    public String ask(String questions) {
        return answer[position++];
    }

    /**
     * метод валидации введенных данных при выборе меню
     *
     * @param question - вопрос
     * @param range    - набор чисел меню
     * @return - ключ иначе сообщение об ошибке
     */
    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean result = false;
        for (int value : range) {
            if (value == key) {
                result = true;
                break;
            }
        }
        if (result) {
            return key;
        } else {
            throw new MenuOutExeption("out of menu range");
        }
    }
}
