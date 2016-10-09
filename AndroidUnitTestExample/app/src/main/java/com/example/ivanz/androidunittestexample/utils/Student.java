package com.example.ivanz.androidunittestexample.utils;

public class Student implements IStudent {

    private String name;
    private int course;
    private double averageMark;

    public Student(String name, int course, double averageMark) {
        this.name = name;
        this.course = course;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean isTopStudent() {
        return averageMark > 8;
    }

    @Override
    public boolean isGoesOnAllPairs() {
        return course>3;
    }
}
