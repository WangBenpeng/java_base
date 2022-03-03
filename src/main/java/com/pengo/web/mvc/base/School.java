package com.pengo.web.mvc.base;

/**
 * @author pengo
 * @description:
 * @date 2022/2/26 22:32
 */
public class School {
    private String name;
    private String address;

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
