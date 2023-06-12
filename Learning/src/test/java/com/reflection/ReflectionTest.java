package com.reflection;

import com.basics.data.Student;
import com.basics.data.StudentDataBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionTest {

    public static List<Student> students = null;
    @BeforeAll
    static void setUp(){
        students = StudentDataBase.getAllStudents();
    }

    @Test
    public void test() throws IllegalAccessException {
        Student student = students.get(0);
        printFields(student);
    }

    public static void printFields(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(obj));
        }
    }
}
