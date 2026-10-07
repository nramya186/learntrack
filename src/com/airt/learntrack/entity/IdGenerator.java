package com.airt.learntrack.entity;

public class IdGenerator {
    // Static counters for generating unique IDs
    private static int studentIdCounter = 1;
    private static int courseIdCounter = 1;
    private static int enrollmentIdCounter = 1;
//Get next student Id
    public static int getNextStudentID(){
        return studentIdCounter++;
    }
    public static int getNextCourseId(){
        return courseIdCounter++;
    }
    public static int getNextEnrollmentID(){
        return enrollmentIdCounter++;
    }
   //Reset counter
    public static void reset(){
        studentIdCounter=1;
        courseIdCounter=1;
        enrollmentIdCounter=1;
    }

}
