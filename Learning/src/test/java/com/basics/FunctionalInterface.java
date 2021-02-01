package com.basics;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class FunctionalInterface {

    @Test
    public void PriorJava8(){

//      Runnable interface implementation
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

//      Comparator interface implementation
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Compare Status is : "+ comparator.compare(3,2));

    }

    @Test
    public void afterJava8(){
//      Runnable interface implementation
        Runnable runnable = ()-> System.out.println("Inside Runnable Using lambda");
        Thread thread = new Thread(runnable);
        thread.start();

//      Comparator interface implementation
        Comparator<Integer> comparator= (o1,o2)->o1.compareTo(o2);
        System.out.println("Compare status is : "+comparator.compare(3,2));

    }
}
