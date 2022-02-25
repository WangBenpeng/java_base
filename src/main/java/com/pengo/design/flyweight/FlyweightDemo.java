package com.pengo.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 10:26
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        Student s1 = Student.create(1, "bob");
        Student s2 = Student.create(2, "tom");
        Student s3 = Student.create(1, "bob");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}

class Student{
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<Integer, Student> cache = new HashMap<>();

    public static Student create(int id, String name) {
        Student student = cache.get(id);
        if (student == null) {
            System.out.println(String.format("create new Student(%s, %s)", id, name));
            student = new Student(id, name);
            cache.put(id, student);
        } else {
            System.out.println(String.format("return cached Student(%s, %s)", student.id, student.name));
        }
        return student;
    }

}
