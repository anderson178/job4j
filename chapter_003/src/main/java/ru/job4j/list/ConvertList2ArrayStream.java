package ru.job4j.list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertList2ArrayStream {

    public Integer[][] toArray(List<Integer> list, int rows) {
        int temp = list.size() % rows == 0 ? 0 : 1;
        int collumns = list.size() / rows + temp;
        //int count = 0;
        //Integer[][] mass = new Integer[rows][collumns];

       // mass = list.stream().mapToInt(x -> x).toArray();
        return list.stream().toArray(a -> new Integer[rows][collumns]);

        //в одномерный массив
        //Integer[] mass = list.stream().toArray(size -> new Integer[list.size()]);


       /* for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns && count != list.size(); j++) {
                mass[i][j] = list.get(count++);
            }
        }*/
       // return mass;
        //return list.stream().toArray(Integer[]::new);
        //return list.stream().mapToInt(x->IntStream.range(0,rows).mapToObj(y -> Integer[]::new)).toArray(Integer[][]::new);

    }

}
