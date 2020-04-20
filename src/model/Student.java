package model;

import java.util.Date;

public class Student {
    private int id_student;
    private String name;
    private String gender;
    private String address;
    private Date date;
    private String phoneNumber;
    private int aClasses;

    public Student(int id_student, String name, String gender, String address, Date date, String phoneNumber, int aClasses) {
        this.id_student = id_student;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.aClasses = aClasses;

    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getaClasses() {
        return aClasses;
    }

    public void setaClasses(int aClasses) {
        this.aClasses = aClasses;
    }

}