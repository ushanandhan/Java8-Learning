package com.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Junit5Test {

    @DisplayName("Should pass non-null message to our test method")
    @ParameterizedTest(name = "{index} => message=''{0}''")
    @ValueSource(strings = {"Hello","World"})
    public void shouldPassMessageAsMethodParameter(String message){
        Assertions.assertNotNull(message);
    }

    @DisplayName("Should pass non-null Enum to our test method")
    @ParameterizedTest(name = "{index} => pet=''{0}''")
    @EnumSource(Pet.class)
    public void shouldPassNonNullEnumValuesAsMethodParameter(Pet pet){
        Assertions.assertNotNull(pet);
    }

    @DisplayName("Should pass only specified Enum value to our test method")
    @ParameterizedTest(name = "{index} => pet=''{0}''")
    @EnumSource(value = Pet.class,names = {"CAT"})
    public void shouldPassNonNullEnumValuesAsMethodParameter1(Pet pet){
        Assertions.assertNotNull(pet);
    }

    @DisplayName("Should pass parameters provied by @CSVsource value to our test method")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1,1,2",
            "2,3,5"
    })
    public void shouldPassCSVValuesAsMethodParameter(int a, int b, int sum){
        Assertions.assertEquals(sum,a+b);
    }

    @DisplayName("Should pass parameters provided by @CSVsource value to our test method")
    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv")
    public void shouldPassCSVValuesAsMethodParameter1(int a, int b, int sum){
        Assertions.assertEquals(sum,a+b);
    }

    @DisplayName("Should pass parameters provided by @MethodSource value to our test method")
    @ParameterizedTest
    @MethodSource("customMethod")
    public void testWithDefaultLocalMethodSource(String argument){
        Assertions.assertNotNull(argument);
    }

    static Stream<String> customMethod(){
        return Stream.of("apple","banana");
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void timeoutTest1(){
        sum(1,2);
    }

    public int sum(int a,int b){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a+b;
    }
}

enum Pet{
    CAT,
    DOG
}
