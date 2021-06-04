package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {

    static Function<String,String> upperFunc = (name)->name.toUpperCase();
    static Function<String,String> addSomeStringFunc = (name)->name.toLowerCase().concat(" default");
    static List<Student> students = null;

    @BeforeAll
    public static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void functionTest(){
        System.out.println(upperFunc.apply("java8"));
        System.out.println(upperFunc.andThen(addSomeStringFunc).apply("java8"));  // Function chaining
        System.out.println(upperFunc.compose(addSomeStringFunc).apply("java8"));
    }

    @Test
    public void returnFunctionTest(){
        String java_8 = FunctionExample.addSomeStringFunc.apply("java8 is by");
        System.out.println(java_8);
    }

    @Test
    public void PredicateAndFunctionTest(){
        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;

        Function<List<Student>, Map<String,Double>> studentFunction = studentList -> {
            Map<String,Double> studentGradeMap = new HashMap<>();
            studentList.forEach(student -> {
                if(gradePredicate.and(gpaPredicate).test(student)){
                    studentGradeMap.put(student.getName(),student.getGpa());
                }
            });
            return studentGradeMap;
        };
        System.out.println(studentFunction.apply(students));
    }
}
