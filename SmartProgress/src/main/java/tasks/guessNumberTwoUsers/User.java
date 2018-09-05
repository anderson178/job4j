package tasks.guessNumberTwoUsers;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.09.2018
 */
public class User {
    private String name;
    private int number;
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
