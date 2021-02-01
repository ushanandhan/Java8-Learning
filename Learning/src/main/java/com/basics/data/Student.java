package com.basics.data;

import com.basics.data.Bike;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@ToString
public class Student {

    private String name;
    private int gradeLevel;
    private double gpa;

    public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities, int noteBooks) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
        this.noteBooks = noteBooks;
    }

    private String gender;
    List<String> activities = new ArrayList<>();
    private int noteBooks;
    private Optional<Bike> bike = Optional.empty();

    public void printActivities(){
        System.out.println(activities);
    }

    public Student(String name){
        this.name = name;
    }
}
