package tasks.guess;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 06.09.2018
 */
public class Start {
   private Answer answer = new ConsoleIn();
   private int minBoundaries = 1;
   private int maxBoundaries = 1000;
   private int randomNumber = new Random().nextInt(maxBoundaries);
   private int temp;
   private User user1;
   private User user2;
   private int lNumber;
   private ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * метод проверки введенной цифры с загаданной
     * @param user - игрок
     */
    private void checkNumber(User user) {
        if (user.getNumber() == this.randomNumber) {
            System.out.println("Winner is " + user.getName() + " number is: " + user.getNumber());
            System.exit(0);
        } else if (user.getNumber() < this.randomNumber) {
                    System.out.println(user.getName() + " your number " + user.getNumber() + " less then guess number");
                    checkMin(user.getNumber());
        } else {
                    System.out.println(user.getName() + " your number " + user.getNumber() + " more then guess number");
                    checkMax(user.getNumber());
        }
    }

    /**
     * метод задает минимальную границу для будущего поиска числа
     * @param inNumber - число указанное игроком или ПК
     */
    private void checkMin(int inNumber) {
        if (inNumber > this.minBoundaries) {
           this.minBoundaries = inNumber;
           this.list.add(inNumber);
        }
    }

    /**
     * метод задает максимальную границу для будущего поиска числа
     * @param inNumber - число указанное игроком или ПК
     */
    private void checkMax(int inNumber) {
        if (inNumber < this.maxBoundaries) {
            this.maxBoundaries = inNumber;
            this.list.add(inNumber);
        }
    }

    /**
     * метод генерации числа.
     * необходим list что бы исключить возможность повторной генерации раннее использованного числа введенного
     * игроком или ПК.
     * @return - сгенерированное число
     */
    private int generationNumber() {
        int temp = (new Random()).ints(this.minBoundaries, this.maxBoundaries).iterator().nextInt();
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) == temp) {
                generationNumber();
            }
        }
        return temp;
    }

    /**
     * метод поочередного запроса чисел от игроков
     */
    private void askNumber() {
        this.user1.setNumber(Integer.parseInt(this.answer.askUser(user1.getName() + " input number:")));
        this.checkNumber(user1);
        if (!this.user2.getName().equals("pc")) {
            this.user2.setNumber(Integer.parseInt(this.answer.askUser(user2.getName() + " input number:")));
        } else {
            this.user2.setNumber(this.generationNumber());
        }
        this.checkNumber(user2);
        this.askNumber();
    }

    /**
     * метод сбора информации об игроках
     */
    public void choicePlayers() {
        String whoSecond;
        this.user1 = new User(answer.askUser("Input name first user"));
        whoSecond = this.answer.askUser("Who second user (pc/human) ?");
        if (whoSecond.equals("human")) {
            this.user2 = new User(answer.askUser("Input name second user"));
        } else {
            this.user2 = new User("pc");
        }
        this.askNumber();
    }

    public static void main(String[] args) {
       new Start().choicePlayers();
    }
}
