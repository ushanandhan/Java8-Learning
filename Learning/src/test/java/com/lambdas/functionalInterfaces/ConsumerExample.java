package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static List<Student> students = null;

    @BeforeAll
    public static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void consumerTest(){
        Consumer<String> c1 = (s)->System.out.println(s.toUpperCase());
        c1.accept("java8");
    }

    @Test
    public void consumerInCustomizedObject(){
        Consumer<Student> studentConsumer = System.out::println;
        students.forEach(studentConsumer);
    }

    @Test
    public void consumerChainingTest(){
        Consumer<Student> nameConsumer = (student)-> System.out.println(student.getName());
        Consumer<Student> activitiesConsumer = (student) -> System.out.println(student.getActivities());

        students.forEach(nameConsumer.andThen(activitiesConsumer));  //Consumer Chaining
    }

    @Test
    public void filteringTest(){
        Consumer<Student> nameConsumer = (student)-> System.out.println(student.getName());
        Consumer<Student> activitiesConsumer = (student) -> System.out.println(student.getActivities());

        students.forEach(student -> {
            if(student.getGradeLevel()>=3 && student.getGpa()>=3.9){
                nameConsumer.andThen(activitiesConsumer).accept(student);
            }
        });
    }
}
