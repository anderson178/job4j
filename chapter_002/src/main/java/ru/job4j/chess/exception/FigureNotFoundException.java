package ru.job4j.chess.exception;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.09.2018
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
