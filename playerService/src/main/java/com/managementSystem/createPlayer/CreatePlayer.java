package com.managementSystem.createPlayer;

public class CreatePlayer {

    private String name;
    private int age;
    private String gender;
    private long contactNumber;
    private String email;
    private String SportsName;

    public CreatePlayer(String name, int age, String gender, long contactNumber, String email, String sportsName) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        SportsName = sportsName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSportsName() {
        return SportsName;
    }

    public void setSportsName(String sportsName) {
        SportsName = sportsName;
    }


}
