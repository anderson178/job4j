package ru.job4j.tracker;

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

}
