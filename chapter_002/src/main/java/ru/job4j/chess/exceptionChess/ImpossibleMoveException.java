package ru.job4j.chess.exceptionChess;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.09.2018
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
