package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    static List<Student> students = null;

    @BeforeAll
    public static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void biConsumerTest(){
        BiConsumer<String,String> biConsumer = (a, b)-> System.out.println("a : "+a+",b : "+b);
        biConsumer.accept("java7","java8");
    }

    @Test
    public void biConsumerChainTest(){
        BiConsumer<Integer,Integer> multiplyConsumer = (a,b)-> System.out.println("Multiplication "+a+", "+b+" is "+a*b);
        BiConsumer<Integer,Integer> divideConsumer = (a,b)-> System.out.println("Division "+a+", "+b+" is "+a/b);

        multiplyConsumer.andThen(divideConsumer).accept(4,6);
    }

    @Test
    public void biConsumerWithObjectTest(){
        BiConsumer<String, List<String>> biConsumer = (name,activities)-> System.out.println(name+": "+activities);
        students.forEach(student -> biConsumer.accept(student.getName(),student.getActivities()));
    }
}
