package tasks.me;

import tasks.guess.User;

public class ForMe {
    public String change(String name) {
        name = name + "Cat";
        String surname = "Kotov";
        return surname;
    }
    public void change(int[] mas) {
        int k = 3;
        for (int i = 0; i<3; i++) {
            mas[i] = k--;
        }
    }
    public void change(Integer count) {
      count = 2;
    }

    public int[] sort(int[] array) {
        boolean cheange = true;
        while (cheange){
            cheange = false;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = temp;
                    cheange = true;
                }
            }
        }
        return array;
    }

    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] != data[index + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       String name = "Dog";
       ForMe fm = new ForMe();
       //fm.
        //change(name);
       // System.out.println(name);
        //name = change(name);
        //System.out.println(name);
        int[] mas = new int[]{2, 6, 9, 1 , 4, 5};
        int[] rst = fm.sort(mas);
        //boolean[] mas = new boolean[]{true, true, true};
        //boolean rst = fm.mono(mas);
       //int [] mas = new int[] {1, 2, 3};
        Integer count = new Integer(1);
        Integer a = null;
        Integer b = null;
        User user1 = new User("Denis");
        User user2 = new User("Denis");

       // boolean rst1 = user1.equals(user2);
        //boolean rst2 = user1 == user2;
        boolean rst3 = a == b;
        boolean rst4 = a.equals(b);
       fm.change(count);
       int l =0;



    }
}
