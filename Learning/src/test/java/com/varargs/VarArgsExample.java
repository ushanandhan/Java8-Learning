package com.varargs;

import org.junit.jupiter.api.Test;

public class VarArgsExample {

    public void run (String a){
        System.out.println("From normal parameter : "+a);
    }

    public void run (String... a){
        System.out.println("From var args : "+a);
    }

    @Test
    public void example(){
        run();
        run("Hellow");
        run("Hello","java");
    }
}
