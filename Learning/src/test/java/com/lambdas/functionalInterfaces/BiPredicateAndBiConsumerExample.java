package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BiPredicateAndBiConsumerExample {

    @Test
    public void biPredicateTest(){
        List<Student> students = StudentDataBase.getAllStudents();

        BiPredicate<Integer,Double> biPredicate = (gradeLevel,gpa)->gradeLevel>=3 && gpa>=3.9;

        BiConsumer<String,List<String>> biConsumer = (name,activities)-> System.out.println(name+" : "+activities);

        students.forEach(student -> {
            if(biPredicate.test(student.getGradeLevel(),student.getGpa())){
                biConsumer.accept(student.getName(),student.getActivities());
            }
        });
    }
}
