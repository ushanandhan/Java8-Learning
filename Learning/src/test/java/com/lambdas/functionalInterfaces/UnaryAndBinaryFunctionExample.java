package com.lambdas.functionalInterfaces;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryFunctionExample {

    @Test
    public void unaryOperatorTest(){
        UnaryOperator<String> stringUnaryOperator = s -> s.concat(" Default");
        System.out.println(stringUnaryOperator.apply("java8"));
    }

    @Test
    public void binaryOperatorTest(){
        BinaryOperator<Integer> integerBinaryOperator = (a,b)->a+b;
        System.out.println(integerBinaryOperator.apply(4,5));
    }

    @Test
    public void comparatorTest(){
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);

        BinaryOperator<Integer> binaryOperator = (a,b)->a+b;

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        BinaryOperator<Integer> minby = BinaryOperator.minBy(comparator);

        System.out.println(binaryOperator.apply(3,4));

        System.out.println("MaxBy : "+maxBy.apply(3,4));
        System.out.println("MinBy : "+minby.apply(3,4));
    }
}
