package com.streams;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    public static List<Student> students = StudentDataBase.getAllStudents();

    @Test
    public void streamMapExample(){
        List<String> nameList = students.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    @Test
    public void streamFlatMapAndDistinctTest(){
        List<String> activities = students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(activities);
    }

    @Test
    public void streamCountTest(){
        long count = students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("Total activities are : "+count);
    }

    @Test
    public void streamComparatorSortExample(){
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


}
