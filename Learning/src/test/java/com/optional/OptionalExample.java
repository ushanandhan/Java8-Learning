package com.optional;

import com.basics.data.Bike;
import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class OptionalExample {

    static Student student = StudentDataBase.studentSupplier.get();

    @Test
    public void of_ofNullable_emptyTest(){
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if(studentOptional.isPresent()){
            System.out.println(studentOptional.get());
        }else{
            System.out.println("Not Found");
        }
    }

    @Test
    public void orElse_orElseGet_orElseThrowTest(){
        Optional<Student> optionalStudent = Optional.ofNullable(OptionalExample.student);
        Optional<Student> optionalStudentEmpty = Optional.ofNullable(null);
        String name = optionalStudent.map(Student::getName).orElse("Default");
        String name2 = optionalStudentEmpty.map(Student::getName).orElse("Default");
        String exception = optionalStudentEmpty.map(Student::getName).orElseThrow(() -> new RuntimeException("Not Available"));
        System.out.println("Optional Or Else : "+name);
        System.out.println("Optional Or Else default call : "+name2);
        System.out.println("Optional Or Else Throw : "+exception);
    }

    @Test
    public void ifPresent_isPresentTest(){
        Optional<Student> optionalStudent = Optional.ofNullable(student);
        if(optionalStudent.isPresent()){
            System.out.println("Is present worked");
        }
        optionalStudent.ifPresent((student)-> System.out.println("if present worked"));
    }

    @Test
    public void map_flatMap_filterTest(){
        Optional<Student> optionalStudent = Optional.ofNullable(student);
        optionalStudent
                .filter(student1 -> student1.getGpa()>=3.4)
                .ifPresent(student1 -> System.out.println(student1));

        Optional<String> optionalString = optionalStudent
                .filter(student1 -> student1.getGpa() >= 3.5)
                .map(Student::getName);
        System.out.println(optionalString);

        Optional<Student> optionalStudentFlatMap = StudentDataBase.getOptionalStudent();
        Optional<String> bikeName = optionalStudentFlatMap
                .filter(student1 -> student1.getGpa() >= 3.5)
                .flatMap(Student::getBike)
                .map(Bike::getName);
        System.out.println(bikeName);
    }
}
