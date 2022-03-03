package com.pengo.web.mvc.base;

/**
 * @author pengo
 * @description:
 * @date 2022/2/26 22:32
 */
public class User {
    private int id;
    private String name;
    private School school;

    public User(int id, String name, School school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public School getSchool() {
        return school;
    }
}
