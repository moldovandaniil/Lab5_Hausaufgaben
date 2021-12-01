package com.company;

import com.company.test.AssertTest;
import database.CreateDB;

public class Main {

    public static void main(String[] args) {
        AssertTest assertTest = new AssertTest();
        assertTest.testMethod();

        CreateDB newDB = new CreateDB();

        newDB.dropAll();

        newDB.createDB();
        newDB.createTableCourse();
        newDB.createTableStudent();
        newDB.createTableTeacher();
        newDB.addFKStudentCourses();
        newDB.addFKCourseEnrolledStudents();
    }
}
