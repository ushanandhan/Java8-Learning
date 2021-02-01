package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiFunctionExample {

    @Test
    public void biFunctionTest(){
        List<Student> students = StudentDataBase.getAllStudents();

        BiPredicate<Integer,Double> studentPredicate = (gradeLevel, gpa)->gradeLevel>=3 && gpa>=3.9;

        BiFunction<List<Student>,BiPredicate<Integer,Double>, Map<String,Double>> biFunction = (studentList,predicate) -> {
            Map<String,Double> studentGradeMap = new HashMap<>();
            studentList.forEach(student -> {
                if(predicate.test(student.getGradeLevel(),student.getGpa())){
                    studentGradeMap.put(student.getName(),student.getGpa());
                }
            });
            return studentGradeMap;
        };

        System.out.println(biFunction.apply(students,studentPredicate));
    }

}
