package com.airt.learntrack.service;

import com.airt.learntrack.entity.IdGenerator;
import com.airt.learntrack.entity.Student;
import com.airt.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    //Add new student
    public Student addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentID();
        Student student = new Student(id, firstName, lastName, email, batch);
        students.add(student);
        System.out.println("Student added :" + student.getDisplayName());
        return student;
    }

    //Add student without email // (constructor overload
    public Student addStudent(String firstName, String lastNme, String batch) {
        return addStudent(firstName, lastNme, null, batch);
    }

    //List all student
    public List<Student> listStudents() {
        return new ArrayList<>(students);
    }

    //Find student by ID
    public Student findStudentByID(int id) throws EntityNotFoundException {
        for (Student student : students) {
            if (student.getId() == id && student.isActive()) {
                return student;
            }
        }
        throw new EntityNotFoundException("Student not fount with id :" + id);
    }

    // update Student
    public void updateStudent(int id, String email, String batch) throws EntityNotFoundException {
        Student student = findStudentByID(id);
        if (email != null) {
            student.setEmail(email);
        }
        if (batch != null) {
            student.setBatch(batch);
        }
        System.out.println("Student updated :" + student.getDisplayName());
    }

    //Deactivate Student //soft delete
    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = findStudentByID(id);
        student.setActive(false);
        System.out.println("Student deactivate :" + student.getDisplayName());
    }

    //Get total count of active students
    public int getActiveStudent() {
        int count = 0;
        for (Student std : students) {
            if (std.isActive()) {
                count++;
            }
        }
        return count;
    }
}
