package com.lambdas.functionalInterfaces;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    static List<Student> students = null;

    @BeforeAll
    public static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void supplierTest(){
        Supplier<Student> studentSupplier = ()->{
            return new Student("Ushan",3,3,"male", Arrays.asList("swimming,jogging"),5);
        };

        Supplier<List<Student>> studentListSupplier = ()->{
            return students;
        };

        System.out.println("Student is : "+studentSupplier.get());
        System.out.println("Students are : "+studentListSupplier.get());
    }
}
