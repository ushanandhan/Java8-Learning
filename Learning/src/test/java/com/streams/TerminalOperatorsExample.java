package com.streams;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class TerminalOperatorsExample {

    public static List<Student> students = null;

    @BeforeAll
    static void setUp(){
        students = StudentDataBase.getAllStudents();
    }
    @Test
    public void collect_joiningTest(){
        String join1 = students.stream()
                .map(Student::getName)
                .collect(joining());
        System.out.println("Joining all together : "+join1);

        String join2 = students.stream()
                .map(Student::getName)
                .collect(joining("-"));
        System.out.println("Joining all together with delimiter: "+join2);

        String join3 = students.stream()
                .map(Student::getName)
                .collect(joining("-","(",")"));
        System.out.println("Joining all together with delimiter, prefix and suffix : "+join3);
    }

    @Test
    public void collect_countTest(){
        Long count = students.stream()
                .filter(student -> student.getGpa()>=3.9)
                .collect(counting());
        System.out.println("Count of students : "+count);
    }

    @Test
    public void collect_mappingTest(){
        List<String> nameList = students.stream()
                .collect(mapping(Student::getName, toList()));
        System.out.println("Name List : "+nameList);
        Set<String> nameSet = students.stream()
                .collect(mapping(Student::getName, toSet()));
        System.out.println("Name Set : "+nameSet);
    }

    @Test
    public void collect_minBy_maxByTest(){
        Optional<Student> minBy = students.stream()
                .min(Comparator.comparing(Student::getGpa));
        System.out.println("MinBy Student : "+minBy.get());

        Optional<Student> maxBy = students.stream()
                .max(Comparator.comparing(Student::getGpa));
        System.out.println("MaxBy Student : "+maxBy.get());
    }

    @Test
    public void collect_summingInt_averageIntTest(){
        Integer summingInt = students.stream()
                .collect(summingInt(Student::getNoteBooks));
        System.out.println("Sum of Notebooks : "+summingInt);

        Double averageInt = students.stream()
                .collect(averagingInt(Student::getNoteBooks));
        System.out.println("Average of Notebooks : "+averageInt);
    }

    @Test
    public void collect_groupingByTest(){

        Map<String, List<Student>> genderStudentMap = students.stream()
                .collect(groupingBy(Student::getGender));
        System.out.println("************* One Argument groupingBy **************");
        System.out.println("List of students by Gender : "+genderStudentMap); //Used only one argument in groupingBy

        Map<String, List<Student>> studentStatusMap = students.stream()
                .collect(groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")); //Used one argument customized function
        System.out.println("************* One Argument groupingBy with customized function ************* ");
        System.out.println("List of students by customized status : "+studentStatusMap);

        Map<Integer, Map<String, List<Student>>> studentMap = students.stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
        System.out.println("************* two Argument groupingBy ************* ");
        System.out.println(studentMap);

        Map<String, Integer> studentNoteBookMap = students.stream()
                .collect(groupingBy(Student::getName,
                        summingInt(Student::getNoteBooks)));
        System.out.println("************* two Argument groupingBy ************* ");
        System.out.println(studentNoteBookMap);

        LinkedHashMap<String, Set<Student>> studentLinkedHasMap = students.stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));
        System.out.println("************* three Argument groupingBy ************* ");
        System.out.println(studentLinkedHasMap);

        Map<Integer, Optional<Student>> maxStudentOptional = students.stream()
                .collect(groupingBy(Student::getGradeLevel,
                        maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println("************* maxBy example ************* ");
        System.out.println(maxStudentOptional);

        Map<Integer,Student> maxStudent = students.stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),
                                Optional::get)));
        System.out.println("************* maxBy example without optional ************* ");
        System.out.println(maxStudent);

        Map<Integer, Map<String, List<Student>>> twoGroupBy = students.stream().collect(groupingBy(Student::getGradeLevel, groupingBy(Student::getGender)));
        System.out.println("Latest : "+twoGroupBy);
    }

    @Test
    public void collect_partitioningByTest(){
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.8;
        Map<Boolean, List<Student>> partitioningMap = students.stream()
                .collect(partitioningBy(gpaPredicate));
        System.out.println("One Argument partitioningBy");
        System.out.println(partitioningMap);

        Map<Boolean, Set<Student>> partitioning_2Set = students.stream()
                .collect(partitioningBy(gpaPredicate,toSet()));
        System.out.println("Two Arguments partitioningBy");
        System.out.println(partitioning_2Set);
    }
}
