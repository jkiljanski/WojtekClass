package com.sciamus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamsFun {
    int fieldInt = 100;


    public static void main(String[] args) {

        IntStreamsFun fun = new IntStreamsFun();

        //Stream.iterate(1, i-> i+1)

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .map(i -> i + 10)
                .peek( i-> System.out.println("peek: "+i))
                //.filter(i -> i%2==1)
                .map(fun::heavyOperation)
                .count();
                //.forEach(i -> System.out.println("Number: " + i));





        HashMap<Integer, String> integerStringHashMap = new HashMap<>();

        integerStringHashMap.put(1, "a");
        integerStringHashMap.put(2, "b");
        integerStringHashMap.put(3, "c");

        List<Integer[]> ints =
        Stream.of(new Integer[]{1}, new Integer[]{2})
                .collect(Collectors.toList());

        var ref = new Object() {
            int i = 0;
        };

        ints.stream()
                .map(array -> array[0]=9);
                //.forEach( t -> ref.i++);

        ints.forEach(array -> System.out.println(array[0]));



    }

    private int heavyOperation(int i) {
        System.out.println("Woooow, that was long: " + i);
        return i * 2+fieldInt;
    }
}
