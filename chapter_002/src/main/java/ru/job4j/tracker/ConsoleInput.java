package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 29.08.2018
 */

public class ConsoleInput implements Input {
    private Scanner scaner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return this.scaner.nextLine();
    }
    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean result = false;
        for (int value: range) {
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
