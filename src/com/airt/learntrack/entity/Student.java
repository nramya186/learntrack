package com.airt.learntrack.entity;

public class Student extends Person{
    private String batch;
    private boolean active;

    //Default constructor
    public Student(){
        super();
        this.active=true;
    }

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active=true;
    }

    public String getBatch() {
        return batch;
    }



    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Override getDisplayName from Person
    @Override
    public String getDisplayName(){
        return super.getDisplayName()+"(Batch "+batch +")";
    }

    //Display Student details

    @Override
    public String toString() {
        return "Student{" +

                ", id=" + id +
                ", Name='" + getDisplayName()+ '\'' +
                ", email='" + email + '\'' +
                ", batch='" + batch + '\'' +
                "active=" + active +
                '}';
    }
}
