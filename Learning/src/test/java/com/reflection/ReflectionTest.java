package com.reflection;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ReflectionTest {

    public static List<Student> students = null;
    @BeforeAll
    static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void test() throws IllegalAccessException {
        String[] columns = {"name","gpa"};
        Student student = students.get(0);
        printFields(student,columns);
    }

    public static void printFields(Object obj,String[] columns) {
        Class<?> clazz = obj.getClass();

        Arrays.stream(columns).forEach(column -> {
            try {
                Field field = clazz.getDeclaredField(column);
                field.setAccessible(true);
                System.out.println(field.getName() + " = " + field.get(obj));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            System.out.println(field.getName() + " = " + field.get(obj));
//        }
    }
}
