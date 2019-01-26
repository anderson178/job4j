package tasks.me;

import tasks.guess.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class ForMe {

    public String change(String name) {
        name = name + "Cat";
        String surname = "Kotov";
        return surname;
    }

    public void change(int[] mas) {
        int k = 3;
        for (int i = 0; i < 3; i++) {
            mas[i] = k--;
        }
    }

    public void change(Integer count) {
        count = 2;
    }

    public int[] sort(int[] array) {
        boolean cheange = true;
        while (cheange) {
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
        /*Predicate<Integer> pred = x -> x > 0;
        Consumer<Integer> cons = x -> System.out.println(x);
        cons.accept(111);
        Function<Integer, String> func = x -> String.valueOf(x) + "test";
        System.out.println(func.apply(5));
        Supplier<String> sup = () -> {
            String name = "Denis";
            return name;
        };

        System.out.println(sup.get());
        System.out.println(pred.test(5)); // true
        System.out.println(pred.test(-1)); //false
        UnaryOperator<String> unop = x -> x+x+x;
        System.out.println(unop.apply("den"));
        BinaryOperator<Integer> binop = (x,y) -> x + y ;
        System.out.println(binop.apply(5,3));
        PredicateMe<Integer> me = x -> x > 0;
        System.out.println(me.applay(3));*/

        List<Integer> names = Arrays.asList(1,2,3);

        //List.of(5, 1, 2).forEach(System.out::print);

       /* String last = 1234;
        //String[] names = {"цу","цу"};
        names.stream().map(n -> last = n).collect(Collectors.toList());
        /*Arrays.stream(names).forEach(
                n -> names[0] = n
        );
        List<String> test=  Arrays.asList("sd","sd2");
        test.stream().forEach(System.out::println);

        /*names.forEach(
                n -> names.set(0,n)
        );*/





    }
    interface PredicateMe<T> {
        boolean applay(T t);
    }
}
