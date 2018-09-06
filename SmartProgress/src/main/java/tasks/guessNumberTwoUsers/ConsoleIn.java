package tasks.guessNumberTwoUsers;
import java.util.Scanner;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 06.09.2018
 */
public class ConsoleIn implements Answer {
    private Scanner scaner = new Scanner(System.in);

    public String askUser(String question) {
        System.out.println(question);
        return this.scaner.nextLine();
    }

}
