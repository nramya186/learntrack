package com.airt.learntrack.service;

import com.airt.learntrack.entity.Course;
import com.airt.learntrack.entity.IdGenerator;
import com.airt.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courses =new ArrayList<>();

    //Add new Course

    public Course addCourse(String courseName,String description,int durationInWeeks){
        int id= IdGenerator.getNextCourseId();
        Course course = new Course(id,courseName,description,durationInWeeks);
        courses.add(course);
        System.out.println("Course added :"+course.getCourseName());
        return course;
    }

    //list all course
    public List<Course> listCourses(){
        return new ArrayList<>(courses);
    }

    //find course ID
    public Course findCourseById(int id) throws EntityNotFoundException{
        for (Course course: courses){
            if(course.getId() == id && course.isActive()){
                return course;
            }
        }
        throw new EntityNotFoundException("Course not found with ID : "+ id);
    }

    //Update course
    public void updateCourse(int id, String description ,int durationInWeeks) throws EntityNotFoundException{
        Course course =findCourseById(id);
        if(description !=null){
            course.setDescription(description);
        }if( durationInWeeks>0){
            course.setDurationInWeeks((durationInWeeks));
        }
        System.out.println("Course updated "+ course.getCourseName());
    }
    // Deactivate course
    public void deactivateCourse(int id) throws EntityNotFoundException {
        Course course = findCourseById(id);
        course.setActive(false);
        System.out.println("Course deactivated: " + course.getCourseName());
    }
    //get total count of active courses
    public int getActiveCourseCount(){
        int count=0;
        for(Course course:courses){
            if(course.isActive()){
                count++;
            }
        }return  count;
    }
}
