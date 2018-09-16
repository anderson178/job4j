package ru.job4j.chess.ExceptionChess;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.09.2018
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
