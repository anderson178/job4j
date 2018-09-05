package tasks.guessNumberTwoUsers;
import java.util.Random;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.09.2018
 */
public class Start {
   private Answer answer = new ConsoleIn();
   private int number = new Random().nextInt(1000);
   private int temp;
   private User user1;
   private User user2;

    public Start(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    /**
     * метод проверки введенной цифры с загаданной
     * @param user - игрок
     */
    public void checkNumber(User user) {
        if (user.getNumber() == this.number) {
            System.out.println("Winner is " + user.getName());
            System.exit(0);
        } else if (user.getNumber() < this.number) {
            System.out.println("Your number less then guess number");
        } else {
            System.out.println("Your number more then guess number");
        }
    }

    /**
     * метод поочередного запроса цифр от игроков
     */
    public void askNumber() {
        this.user1.setNumber(Integer.parseInt(this.answer.askUser(user1.getName() + " input number:")));
        this.checkNumber(user1);
        this.user2.setNumber(Integer.parseInt(this.answer.askUser(user2.getName() + " input number:")));
        this.checkNumber(user2);
        this.askNumber();
    }

    public static void main(String[] args) {
        Answer answer = new ConsoleIn();
        User user1 = new User(answer.askUser("Input name first user"));
        User user2 = new User(answer.askUser("Input name second user"));
        new Start(user1, user2).askNumber();
    }

}
