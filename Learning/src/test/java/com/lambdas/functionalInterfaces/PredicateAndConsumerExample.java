package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static List<Student> students = null;

    @BeforeAll
    public static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void printNameAndActivities(){
        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;

        BiConsumer<String,List<String>> biConsumer = (name,activities)-> System.out.println(name+" : "+activities);

        students.forEach(student -> {
            if(gpaPredicate.and(gradePredicate).test(student)){
                biConsumer.accept(student.getName(),student.getActivities());
            }
        });

    }
}
