package com.interview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciTest {

    @Test
    public void testFibonacciNormalWay(){
        long number = 5;
        long first = 0, second = 1, third;
        System.out.println(first);
        System.out.println(second);
        for (int i=3;i<=number;i++){
            third = first+second;
            System.out.println(third);
            first = second;
            second = third;
        }
    }

    @Test
    public void testFibonacciUsingList(){
        int numbers = 5;
        int f = 0, s = 1, t;
        List<Integer> fibonacciArray = new ArrayList<>();
        fibonacciArray.add(f);
        fibonacciArray.add(s);
        for (int i = 3;i<=numbers;i++){
            t = f+s;
            fibonacciArray.add(t);
            f = s;
            s = t;
        }
        System.out.println(fibonacciArray);
        System.out.println("3rd position is : "+fibonacciArray.get(2));
    }

    @Test
    public void testFibonacciUsingStreamsReduce(){
        int number = 5;
        List<Integer> collect = Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(number)
                .map(n -> n[0])
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
