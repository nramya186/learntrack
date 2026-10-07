package com.airt.learntrack.entity;

public class Person {
    protected  int id;
    protected  String firstName;
    protected String lastName;
    protected String email;

    //Default Constructor
    public Person(){
    }
    //Parameterized constructor


    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Method to display Name
    public String getDisplayName(){
        return firstName +" "+lastName;
    }
}
