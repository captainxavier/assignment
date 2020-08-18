package com.mohamed.projectapplication;

public class User {

    private String first_name,last_name,gender;
    private int id_number,yearOfStudy;

    public User() {
    }

    public User(String first_name, String last_name, String gender, int id_number, int yearOfStudy) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.id_number = id_number;
        this.yearOfStudy = yearOfStudy;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
