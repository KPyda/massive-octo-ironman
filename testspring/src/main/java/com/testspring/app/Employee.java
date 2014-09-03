package com.testspring.app;

/**
 * Created by Praktykant on 03.09.14.
 */

/**
 * POJO - Plain Old Java Object
 * soft requirements:
 *      - default constructor
 *      - id field
 *      - private fields (accesible from getter and setter methods)
 *      - class being non-final or implementing interface that declares all method public
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee() {}

    public Employee(String fname, String lname, int salary) {
        firstName = fname;
        lastName = lname;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
