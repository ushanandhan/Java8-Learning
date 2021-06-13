package com.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamExample {

    @Test
    public void intStreamTest(){
        System.out.println(IntStream.rangeClosed(1, 6).sum());
        System.out.println(IntStream.range(1,6).sum());
        System.out.println(IntStream.rangeClosed(1,6).max().getAsInt());
        IntStream.range(1,10).forEach(value -> System.out.println(value));
        System.out.println(IntStream.range(1,5).count());
    }

    @Test
    public void mapToObj(){
        List<Integer> collect = IntStream.rangeClosed(1, 5)
                .mapToObj(value -> new Integer(value))
                .collect(Collectors.toList());

        List<int[]> collect1 = Stream.of("A", "B", "C")
                .map(s -> {
                    if (s.equals("A")) {
                        return new int[]{1};
                    } else if (s.equals("B")) {
                        return new int[]{2};
                    } else {
                        return new int[]{3};
                    }
                })
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect1);
    }
}
