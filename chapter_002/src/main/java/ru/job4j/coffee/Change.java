package ru.job4j.coffee;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.10.2018
 */
public class Change {
    private int value;
    private int price;

    public Change(int value, int price) {
        this.value = value;
        this.price = price;
    }

    private final int[] coins = new int[]{10, 5, 2, 1};
    private int[] amountCoins = new int[coins.length];

    /**
     * метод расчета длины будущего выходного массива сдачи
     *
     * @return
     */
    private int lengthMass() {
        int count = 0;
        for (int i : this.amountCoins) {
            count += i;
        }
        return count;
    }

    /**
     * метод подсчта количества монет и их наменалов для формирвания массива с сдачей
     * массив coins - наменалы монет
     * массив amountCoins - кол-во монет по каждому наменалу монеты
     */
    private void amountCoins() {
        int ostatok = this.value - this.price;
        for (int i = 0; i < this.coins.length && ostatok > 0; i++) {
            amountCoins[i] = ostatok / this.coins[i];
            ostatok = ostatok - this.amountCoins[i] * this.coins[i];
        }
    }

    /**
     * метод заполнения резуьтирующего массива с наором монет по каждому наменалу
     *
     * @return
     */
    public int[] changes() {
        this.amountCoins();
        int count = 0;
        int[] rst = new int[this.lengthMass()];
        for (int i = 0; i < this.amountCoins.length; i++) {
            for (int j = 0; j < this.amountCoins[i]; j++) {
                rst[count++] = this.coins[i];
            }
        }
        return rst;
    }
}
