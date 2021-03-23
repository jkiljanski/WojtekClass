package com.sciamus;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class SequenceChecker {

    public static void main(String[] args) {

        for (var seed = 0; seed < 10L; seed++) {
            checkStreamForPattern(seed);
        }


    }

    private static void checkStreamForPattern(int seed) {
        Random random = new Random(seed);

        long start = System.currentTimeMillis();
        IntStream inputStream = IntStream.generate(() -> random.nextInt(9));

        long count = inputStream.takeWhile(new Limitter(8))
                //.peek(System.out::println)
                .count();
        long end = System.currentTimeMillis();

        System.out.println(seed +":"+count + ", and took:" + (end-start) + "ms");
    }

    private static class Limitter implements IntPredicate {

        private final int maxValue;
        private int seeking = 0;

        private Limitter(int maxValue) {
            this.maxValue = maxValue;
        }

        @Override
        public boolean test(int value) {
            if (seeking > maxValue){
                return false;
            }
            if(seeking == value){
                seeking = value+1;
            }else {
                seeking = 0;
            }
            return true;
        }
    }
}
