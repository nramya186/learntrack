package com.airt.learntrack.ui;

import com.airt.learntrack.entity.Course;
import com.airt.learntrack.entity.Enrollment;
import com.airt.learntrack.entity.Student;
import com.airt.learntrack.exception.EntityNotFoundException;
import com.airt.learntrack.service.CourseService;
import com.airt.learntrack.service.EnrollmentService;
import com.airt.learntrack.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private  static StudentService studentService = new StudentService();
    private  static CourseService courseService= new CourseService();
    private static EnrollmentService enrollmentService= new EnrollmentService(studentService,courseService);
    private static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("    Welcome to LearnTrack     ");
        System.out.println("   Student 7 Course Management System ");
        System.out.println("==============================================");

        while (true){
            displayMainMenu();
            int choice = readIntInput("enter your choice :");

            try{
                switch (choice){
                    case 1:
                        manageStudents();
                        break;
                    case 2:
                        manageCourses();
                        break;
                    case 3:
                        manageEnrollments();
                        break;
                    case 4:
                        System.out.println("\tThank you for using LearnTrack!");
                      //  return;
                    default:
                        System.out.println("Invalid option . Please try again");
                }
            }catch (EntityNotFoundException e){
                System.out.println("Error :"+e.getMessage());
            }catch (Exception e){
                System.out.println("An unexpected error occurred :"+ e.getMessage());
            }
        }
    }
    private static void displayMainMenu(){
        System.out.println("\n ==================MAIN MENU ==============");
        System.out.println("1. Student Management ");
        System.out.println("2  Course management");
        System.out.println("3  Enrollment Management");
        System.out.println("4  exit");
        System.out.println("=============================================");
    }

    private static void manageStudents(){
        while (true){
            System.out.println("\n --------Student Management ----------");
            System.out.println("1.  Add student");
            System.out.println("2.  view all student");
            System.out.println("3   Search student by Id");
            System.out.println("4.  Deactivate Student");
            System.out.println("0   Back to main Menu");

            int choice = readIntInput("enter choice :");

            try{
                switch (choice){
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewAllStudents();
                        break;
                    case 3:
                        seachStudent();
                        break;
                    case 4:
                        deactivateStudent();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            }catch (EntityNotFoundException e){
                System.out.println("error "+ e.getMessage());
            }
        }
    }

    private static void addStudent(){
        System.out.println("Enter First Name: ");
        String firstName= scanner.nextLine();
        System.out.println("enter Last Name:");
        String lastName= scanner.nextLine();
        System.out.println("Enter Email.(optional):");
        String email= scanner.nextLine();
        if(email.isEmpty()) email =null;

        System.out.println("Enter Batch: ");
        String batch = scanner.nextLine();

        Student  student;
        if(email!= null){
            student= studentService.addStudent(firstName,lastName,email,batch);
        }else {
            student=studentService.addStudent(firstName,lastName,batch);
        }
        System.out.println(" student added successfully with Id: "+ student.getId());
    }
    private  static void viewAllStudents(){
        List<Student> students =studentService.listStudents();
        if(students.isEmpty()){
            System.out.println("No students found");
            return;
        }
        System.out.println("\nId\tName\t\tEmail\t\tBatch");
        System.out.println("---------------------------------");
        for(Student s: students){
            System.out.printf("%d\t%-20s\t%-20s\t%s%n",s.getId(),s.getDisplayName(),s.getEmail(),s.getBatch());
        }
    }

    private static void seachStudent(){
        int id =readIntInput("Enter Student Id:");
        try{
            Student student= studentService.findStudentByID(id);
            System.out.println("\n Found :"+student.getDisplayName());
            System.out.println("Email "+(student.getEmail()!=null?student.getEmail():"N/A"));
            System.out.println("Batch :"+student.getBatch());
            System.out.println("Status : "+(student.isActive()?"active:":"Inactive"));
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    //----deactive student
    private static void deactivateStudent() {
        int id = readIntInput("Enter Student ID to deactivate: ");
        try {
            studentService.deactivateStudent(id);
            System.out.println(" Student deactivated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //managecourse
    private static void manageCourses() {
        while (true) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course by ID");
            System.out.println("4. Deactivate Course");
            System.out.println("0. Back to Main Menu");

            int choice = readIntInput("Enter choice: ");

            try {
                switch (choice) {
                    case 1:
                        addCourse();
                        break;
                    case 2:
                        viewAllCourses();
                        break;
                    case 3:
                        searchCourse();
                        break;
                    case 4:
                        deactivateCourse();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    //add course
    private static void addCourse() {
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        int duration = readIntInput("Enter Duration (weeks): ");

        Course course = courseService.addCourse(courseName, description, duration);
        System.out.println("✓ Course added successfully with ID: " + course.getId());
    }
   //view all course
   private static void viewAllCourses() {
       List<Course> courses = courseService.listCourses();
       if (courses.isEmpty()) {
           System.out.println("No courses found.");
           return;
       }

       System.out.println("\nID\tCourse Name\t\tDuration (weeks)");
       System.out.println("------------------------------------------------");
       for (Course c : courses) {
           System.out.printf("%d\t%-20s\t%d%n",
                   c.getId(), c.getCourseName(), c.getDurationInWeeks());
       }
   }

    private static void searchCourse() {
        int id = readIntInput("Enter Course ID: ");
        try {
            Course course = courseService.findCourseById(id);
            System.out.println("\n✓ Found: " + course.getCourseName());
            System.out.println("  Description: " + course.getDescription());
            System.out.println("  Duration: " + course.getDurationInWeeks() + " weeks");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deactivateCourse() {
        int id = readIntInput("Enter Course ID to deactivate: ");
        try {
            courseService.deactivateCourse(id);
            System.out.println("✓ Course deactivated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void manageEnrollments() {
        while (true) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View All Enrollments");
            System.out.println("3. View Enrollments by Student");
            System.out.println("4. Mark Enrollment Status");
            System.out.println("0. Back to Main Menu");

            int choice = readIntInput("Enter choice: ");

            try {
                switch (choice) {
                    case 1:
                        enrollStudent();
                        break;
                    case 2:
                        viewAllEnrollments();
                        break;
                    case 3:
                        viewEnrollmentsByStudent();
                        break;
                    case 4:
                        markEnrollmentStatus();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private static void enrollStudent() {
        int studentId = readIntInput("Enter Student ID: ");
        int courseId = readIntInput("Enter Course ID: ");

        try {
            Enrollment enrollment = enrollmentService.enrollStudent(studentId, courseId);
            System.out.println("✓ Student enrolled successfully!");
            System.out.println("  Enrollment ID: " + enrollment.getId());
            System.out.println("  Date: " + enrollment.getEnrollmentDate());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void viewAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        System.out.println("\nID\tStudent ID\tCourse ID\tStatus");
        System.out.println("------------------------------------------------");
        for (Enrollment e : enrollments) {
            System.out.printf("%d\t%d\t\t%d\t\t%s%n",
                    e.getId(), e.getStudentId(), e.getCourseId(), e.getStatus());
        }
    }
    private static void viewEnrollmentsByStudent() {
        int studentId = readIntInput("Enter Student ID: ");
        List<Enrollment> enrollments = enrollmentService.getEnrollmentListByStudentId(studentId);

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found for this student.");
            return;
        }

        System.out.println("\nEnrollments for Student ID: " + studentId);
        System.out.println("Course ID\tStatus\t\tDate");
        System.out.println("------------------------------------------------");
        for (Enrollment e : enrollments) {
            System.out.printf("%d\t\t%s\t\t%s%n",
                    e.getCourseId(), e.getStatus(), e.getEnrollmentDate());
        }
    }
    private static void markEnrollmentStatus() {
        int enrollmentId = readIntInput("Enter Enrollment ID: ");
        System.out.println("Enter Status (ACTIVE/COMPLETED/CANCELLED): ");
        String status = scanner.nextLine().toUpperCase();

        try {
            enrollmentService.markEnrollmentStatus(enrollmentId, status);
            System.out.println(" Enrollment status updated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Helper method to read integer input with validation
    private static int readIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
