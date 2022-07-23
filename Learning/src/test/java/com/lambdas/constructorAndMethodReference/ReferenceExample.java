package com.lambdas.constructorAndMethodReference;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ReferenceExample {

    private static boolean test(Student student){
        return student.getGpa()>=3;
    }

    @Test
    public void functionMethodReferenceTest(){
        Function<String,String> toUpperFuncLambda = s -> s.toUpperCase();
        Function<String,String> toUpperFuncMethodReference = String::toUpperCase;

        System.out.println(toUpperFuncLambda.apply("java8 Using Lambda"));
        System.out.println(toUpperFuncMethodReference.apply("java8 Using Method Reference"));
    }

    @Test
    public void consumerMethodReferenceTest(){
        /**
         * Ordinary way
         */
        Consumer<Student> studentConsumer = student -> System.out.println(student.getName());
        /**
         * ClassName::MethodName
         */
        Consumer<Student> studentConsumer1 = Student::getGender;

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(studentConsumer.andThen(studentConsumer1));
    }

    @Test
    public void staticMethodReferenceTest(){
        Predicate<Student> gradeLevelPredicate = ReferenceExample::test;
        System.out.println(gradeLevelPredicate.test(StudentDataBase.studentSupplier.get()));
    }

    @Test
    public void constructorMethodReferenceTest(){
        Supplier<Student> studentSupplier = Student::new;
        Function<String,Student> studentFunction = Student::new;
        System.out.println(studentSupplier.get());
        System.out.println("New Student : "+studentFunction.apply("USHAN"));
    }
}
