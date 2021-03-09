package com.sciamus;

import java.util.Optional;
import java.util.stream.IntStream;

public class OptionalFun {

    public static void main(String[] args) {

        Optional<String> maybeCow1 = Optional.empty();

        String finalCowName1 = maybeCow1.map(s -> s+"#123")
                .toString();


        Optional<String> maybeCow2 = Optional.of("Betty");




        System.out.println("Cow1: "+finalCowName1);
        System.out.println("Cow2: "+finalCowName2);


    }
}
