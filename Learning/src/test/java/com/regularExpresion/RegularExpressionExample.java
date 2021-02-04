package com.regularExpresion;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExample {

    @Test
    public void example1(){
        Pattern pattern = Pattern.compile(".m");
        Matcher matcher = pattern.matcher("am");
        Boolean b = matcher.matches();
        System.out.println(b);

        System.out.println("1. "+Pattern.matches("[amn]*","amn"));
        System.out.println("2. "+Pattern.matches("[^amn]","c"));
        System.out.println("3. "+Pattern.matches("[a-zA-S]","T"));
        System.out.println("4. "+Pattern.matches("[MS][a-z]{5}","Monica"));
        System.out.println("5. "+Pattern.matches("[xyz]?","x"));
        System.out.println("6. "+Pattern.matches("[xyz]+","xxx"));
        System.out.println("7. "+Pattern.matches("[xyz]*","xyyza"));
        System.out.println("8. "+Pattern.matches("\\d","1"));
        System.out.println("9. "+Pattern.matches("\\D","D"));
    }

}
