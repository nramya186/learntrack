# LearnTrack

Student & Course Management System - Core Java Project

## Features
- Student Management
- Course Management
- Enrollment Management
- Console-based UI

## How to Run
```bash
javac -d out src/com/airtribe/learntrack/**/*.java
java -cp out com.airtribe.learntrack.ui.Main
```
## Class Diagram

```mermaid
classDiagram
    class Person {
        -int id
        -String firstName
        -String lastName
        -String email
        +getDisplayName() String
    }

    class Student {
        -String batch
        -boolean active
        +getDisplayName() String
    }

    class Course {
        -int id
        -String courseName
        -String description
        -int durationInWeeks
        -boolean active
    }

    class Enrollment {
        -int id
        -int studentId
        -int courseId
        -LocalDate enrollmentDate
        -String status
    }

    class StudentService {
        -List~Student~ students
        +addStudent(...)
        +findStudentByID(int) Student
        +deactivateStudent(int)
        +listStudents() List~Student~
    }

    class CourseService {
        -List~Course~ courses
        +addCourse(...)
        +findCourseById(int) Course
        +deactivateCourse(int)
        +listCourses() List~Course~
    }

    class EnrollmentService {
        -List~Enrollment~ enrollments
        -StudentService studentService
        -CourseService courseService
        +enrollStudent(int, int) Enrollment
        +getAllEnrollments() List~Enrollment~
        +markEnrollmentStatus(int, String)
    }

    class IdGenerator {
        -static int studentIdCounter
        -static int courseIdCounter
        -static int enrollmentIdCounter
        +static getNextStudentId() int
        +static getNextCourseId() int
        +static getNextEnrollmentId() int
    }

    class EntityNotFoundException {
        +EntityNotFoundException(String)
    }

    class Main {
        +main(String[]) void
    }

    Person <|-- Student : extends
    StudentService "1" o-- "*" Student : manages
    CourseService "1" o-- "*" Course : manages
    EnrollmentService "1" o-- "*" Enrollment : manages
    EnrollmentService --> StudentService : validates student
    EnrollmentService --> CourseService : validates course
    Enrollment --> Student : refers to student by ID
    Enrollment --> Course : refers to course by ID

    StudentService ..> IdGenerator : generates IDs
    CourseService ..> IdGenerator : generates IDs
    EnrollmentService ..> IdGenerator : generates IDs

    StudentService ..> EntityNotFoundException : may throw
    CourseService ..> EntityNotFoundException : may throw
    EnrollmentService ..> EntityNotFoundException : may throw
    Main ..> StudentService : uses
    Main ..> CourseService : uses
    Main ..> EnrollmentService : uses
```