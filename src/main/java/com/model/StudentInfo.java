package com.model;

public class StudentInfo {
    public String name;

    public String university;
    public String roll_no;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", rollno=" + roll_no +
                '}';
    }
}
