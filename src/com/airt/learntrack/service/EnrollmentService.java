package com.airt.learntrack.service;

import com.airt.learntrack.entity.Enrollment;
import com.airt.learntrack.entity.IdGenerator;
import com.airt.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private List<Enrollment> enrollmentList = new ArrayList<>();
private  StudentService studentService;
private  CourseService courseService;

//Constructor
    public EnrollmentService(StudentService studentService,CourseService courseService){
        this.courseService=courseService;
        this.studentService=studentService;
    }

    //Enroll student in course
    public Enrollment enrollStudent(int srudentId,int courseId)throws EntityNotFoundException {
        //validate student
        studentService.findStudentByID(srudentId);
        //validate course
        courseService.findCourseById(courseId);

        //create enrollment
        int id = IdGenerator.getNextEnrollmentID();
        Enrollment enrollment= new Enrollment(id,srudentId,courseId);
        enrollmentList.add(enrollment);
        System.out.println("Student"+srudentId+"enrolled in course "+courseId);
        return enrollment;
    }

    //Get all enrollment for a student
    public List<Enrollment> getEnrollmentListByStudentId(int studentId){
        List<Enrollment> result= new ArrayList<>();
        for(Enrollment enrollment:enrollmentList){
            if(enrollment.getStudentId()==studentId){
                result.add(enrollment);
            }
        }return result;
    }
    //Get all enrollments
    public List<Enrollment> getAllEnrollments(){
        return new ArrayList<>(enrollmentList);
    }

    //mark enrollment status
    public void markEnrollmentStatus(int enrollId,String status)throws EntityNotFoundException{
        for(Enrollment enrollment:enrollmentList){
            if(enrollment.getId() ==enrollId){
                enrollment.setStatus(status);
                System.out.println("Enrollment "+enrollId+"marked as"+status);
                return;
            }
        }throw new EntityNotFoundException("Enrollment not found with Id"+enrollId);
    }
    //Get enrollment count
    public int getEnrollmentCount(){
        return enrollmentList.size();
    }
}
