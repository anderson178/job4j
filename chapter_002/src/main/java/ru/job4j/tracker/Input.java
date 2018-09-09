package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 31.08.2018
 */
public interface Input {
    String ask(String question);

    int ask(String question, ArrayList<Integer> range);
}
