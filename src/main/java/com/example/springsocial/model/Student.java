package com.example.springsocial.model;

public class Student {

    private String name;
    private int id;
    private int mobileNumber;

    public Student(String name, int id, int mobileNumber) {
        this.name = name;
        this.id = id;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
