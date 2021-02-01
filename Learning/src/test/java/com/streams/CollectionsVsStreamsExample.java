package com.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CollectionsVsStreamsExample {

    @Test
    public void differencTest(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Ushan");
        names.add("Kevin");
        names.add("Paul");

        for (String name: names) {      // ForEach Normally
            System.out.println(name);
        }

        names.stream()
                .forEach(name-> System.out.println(name));  //ForEach Using Streams

        names.stream()
                .forEach(System.out::println);      //ForEach Using MethodReference
    }
}
