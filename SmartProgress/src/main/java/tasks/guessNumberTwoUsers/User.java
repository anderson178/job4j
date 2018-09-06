package tasks.guessNumberTwoUsers;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 06.09.2018
 */
public class User {
    private String name;
    private int number;
    private String type;
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
        return this.number;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
