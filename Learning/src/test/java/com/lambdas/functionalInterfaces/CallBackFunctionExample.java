package com.lambdas.functionalInterfaces;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class CallBackFunctionExample {

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if(lastName!=null){
            System.out.println(lastName);
        }else {
            callback.accept(firstName);
        }
    }

    @Test
    public void callbackTest(){
        hello("ushan","nandhan",value -> {
            System.out.println("No lastname provided for "+value);
        });
    }

    @Test
    public void callback1Test(){
        hello("ushan",null,value -> {
            System.out.println("No lastname provided for "+value);
        });
    }
}
