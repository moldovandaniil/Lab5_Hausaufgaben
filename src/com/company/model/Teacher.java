package com.company.model;


import java.util.List;

/**
 * Teacher Class extends Person Class
 */
public class Teacher extends Person{
    private List<Course> courses;

    /**
     * Constructor with calling the super()
     * from Person class
     */
    public Teacher(String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses=courses;
    }

    /**
     * Getters and Setters
     */
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Remove a course
     * @param course the course that should be removed
     */
    public void deleteCourse(Course course)
    {
        courses.remove(course);
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }
}
