package ru.job4j.chess.ExceptionChess;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.09.2018
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
