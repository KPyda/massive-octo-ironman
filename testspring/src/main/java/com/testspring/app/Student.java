package com.testspring.app;

/**
 * Created by Praktykant on 02.09.14.
 */
public class Student {
    private String name;

    public Student() {}

    public Student(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
