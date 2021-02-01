package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    @Test
    public void predicateTest(){
        Predicate<Integer> predicate = (integer -> integer%2==0);
        System.out.println(predicate.test(44));
    }

    @Test
    public void predicateAndTest(){
        Predicate<Integer> predicate1 = (integer -> integer%2==0);
        Predicate<Integer> predicate2 = (integer -> integer%5==0);
        System.out.println(predicate1.and(predicate2).test(40));  // And Check
        System.out.println(predicate1.or(predicate2).test(45));   // Or Check
        System.out.println(predicate1.or(predicate2).negate().test(25)); // Negate the outcome
    }

    @Test
    public void objectPredicateTest(){
        List<Student> students = StudentDataBase.getAllStudents();
        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;

        students.forEach(student -> {
            if(gradePredicate.and(gpaPredicate).test(student)){
                System.out.println(student);
            }
        });
    }
}
