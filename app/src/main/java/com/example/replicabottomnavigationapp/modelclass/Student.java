package com.example.replicabottomnavigationapp.modelclass;

import java.io.Serializable;

public class Student implements Serializable {
    private String studentname;
    private String gender;
    private String age;
    private String address;

    public Student(String studentname, String gender, String age, String address) {
        this.studentname = studentname;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String getFullname() {
        return studentname;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}