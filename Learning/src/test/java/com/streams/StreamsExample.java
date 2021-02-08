package com.streams;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static List<Student> students = null;

    @BeforeAll
    static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void mapTest(){
        List<String> nameList = students.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    @Test
    public void flatMap_DistinctTest(){
        List<String> activities = students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(activities);
    }

    @Test
    public void countTest(){
        long count = students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("Total activities are : "+count);
    }

    @Test
    public void comparatorSortTest(){
        List<Student> studentList = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println("*********** Name Sorted ************");
        System.out.println(studentList);

        List<Student> studentList1 = students.stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
        System.out.println("********** GPA reverse Sorted ******");
        System.out.println(studentList1);

    }

    @Test
    public void reduceTest(){
        System.out.println("*************** Without Identity *****");
        List<Integer> integers = Arrays.asList(1,3,5,7);
        Optional<Integer> optionalReduce = integers.stream()
                .reduce((a, b) -> a * b);
        System.out.println(optionalReduce.get());

        System.out.println("*************** With Identity *********");
        Integer reduce = integers.stream()
                .reduce(2, (a, b) -> a * b);
        System.out.println(reduce);
    }

    @Test
    public void reduceWithObj(){
        Optional<Student> optionalStudent = students.stream()
                .reduce((std1, std2) -> {
                    if (std1.getGpa() > std2.getGpa()) {
                        return std1;
                    } else {
                        return std2;
                    }
                });
        System.out.println(optionalStudent.get());
    }

    @Test
    public void filterMap_ReduceTest(){
        Integer count = students.stream()
                .filter(student -> student.getGradeLevel() >= 3)
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);
        System.out.println("Total No of books are : "+count);
    }

    @Test
    public void limit_SkipTest(){
        List<Integer> integers = Arrays.asList(6,7,8,9,10,11,12,13,14,15);

        Optional<Integer> maxValue = integers.stream()
                .skip(3)
                .limit(6)
                .reduce((a, b) -> a > b ? a : b);

        if (maxValue.isPresent()){
            System.out.println("Int Max value is : "+maxValue.get());
        }else{
            System.out.println("No Max value found");
        }
    }

    @Test
    public void matchTest(){
        boolean allMatch = students.stream()
                .allMatch(student -> student.getGpa() > 3.5);
        System.out.println("Is All match : "+allMatch);
        boolean anyMatch = students.stream()
                .anyMatch(student -> student.getGpa() > 3.5);
        System.out.println("Is Any match : "+anyMatch);
        boolean noneMatch = students.stream()
                .noneMatch(student -> student.getGpa() > 4);
        System.out.println("Is None Match : "+noneMatch);
    }

    @Test
    public void of_Iterate_generateTest(){
        Stream<String> stringStream = Stream.of("adam","dan","julia");
        stringStream.forEach(System.out::println);

        Stream.iterate(1,integer -> integer+2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("***********************************");
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
