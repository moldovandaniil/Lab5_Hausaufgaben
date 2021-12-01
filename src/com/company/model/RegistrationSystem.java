package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * RegistrationSystem class
 */
public class RegistrationSystem {

    /*
     * We will need a list of all the possible
     * classes in order to iterate through
     * the needed arrays/parameters
     */
    public List<Course> courseList;
    public List<Student> studentList;
    public List<Teacher> teacherList;

    /**
     * Constructor
     * @param courseList list of courses
     * @param studentList list of students
     * @param teacherList list of teachers
     */
    public RegistrationSystem(List<Course> courseList, List<Student> studentList, List<Teacher> teacherList) {
        this.courseList = courseList;
        this.studentList = studentList;
        this.teacherList = teacherList;
    }

    public RegistrationSystem(){}

    /**
     * Getters and Setters
     */
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    /**
     * Register the student to the course
     * @param course course
     * @param student student
     * @return true if possible
     */
    public boolean register(Course course, Student student)
    {
        /*
         * Check if there is a free slot in the course enrollment list.
         * Otherwise print the available courses and return false
         */
        if(course.getStudentsEnrolled().size() == course.getMaxEnrollment()){
            System.out.println("The maximum amount of students for this course is reached!");
            System.out.println("Please enroll in the courses below!");

            /*
             * Iterate through all the courses and check for the
             * ones with free slots. Print them and return false.
             */
            for(Course c:courseList){
                if(c.getStudentsEnrolled().size() == c.getMaxEnrollment()){
                    continue;
                }
                System.out.println(c.getName());
            }
            return false;
        }

        /*
         * If there is a free slot in the course enrollment list
         * add the student (the student itself adds automatically
         * the course to the courseList). Also, we have to check for
         * the max 30 credits rule!
         */
        if(student.getTotalCredits() + course.getCredits() > 30){
            System.out.println("ERROR! You exceeded the number of total credits!");
            return false;
        }

        /* Check if the student is already enrolled */
        for(Student s:course.getStudentsEnrolled()){
            if(s.getStudentId() == student.getStudentId()){
                System.out.println("STUDENT ALREADY ENROLLED!");
                return false;
            }
        }

        course.addStudent(student);
        student.addCredits(course.getCredits());

        return true;
    }


    /**
     * @return Courses with free places
     */
    public List<Course> retrieveCoursesWithFreePlaces()
    {
        /*
         * Create an empty list that will have
         * courses with free places added to it
         */
        List<Course> courseWithFreePlaces = new ArrayList<>();

        /*
         * Iterate through the courseList and
         * retrieve courses with free places
         */
        for(Course c:courseList){
            if(c.getStudentsEnrolled().size()
                    == c.getMaxEnrollment()){
                continue;
            }
            courseWithFreePlaces.add(c);
        }

        return courseWithFreePlaces;
    }

    /**
     * @param course course
     * @return enrolled students to the specified course
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course)
    {
        return course.getStudentsEnrolled();
    }


    /**
     * @return all the courses
     */
    public List<Course> getAllCourses()
    {
        return courseList;
    }

    /**
     * If a setCredit setter is called from the
     * Course class, then modify all the students
     * credits respectively to modified value.
     * @param oldCredits old credit value for the course
     * @param newCredits new credit value
     * @param modifiedCourse the course that has been changed
     */
    public void updateCredits(int oldCredits, int newCredits, Course modifiedCourse)
    {
        for(Student student: modifiedCourse.getStudentsEnrolled()){
            student.addCredits(-oldCredits);
            student.addCredits(newCredits);

        }

    }

    /**
     * Remove the students from the course
     * which has been removed by the professor
     * @param removedCourse the course that has been removed by the professor
     */
    public void removeStudents(Course removedCourse)
    {
        /* Set the list of students as empty */
        removedCourse.setStudentsEnrolled(new ArrayList<Student>());
    }





}
