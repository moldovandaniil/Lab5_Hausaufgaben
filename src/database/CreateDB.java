package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String DB_URL_Final = "jdbc:mysql://localhost:3306/HAUSAUFGABEN";
    static final String USER = "root";
    static final String PASS = "root";

    public void createDB(){
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE HAUSAUFGABEN";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropAll(){
        try(Connection conn = DriverManager.getConnection(DB_URL_Final, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DROP DATABASE HAUSAUFGABEN";
            stmt.executeUpdate(sql);
            System.out.println("Database dropped successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableCourse(){
        try(Connection conn = DriverManager.getConnection(DB_URL_Final, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE Course " +
                    "(id INTEGER not NULL, " +
                    " Name VARCHAR(255), " +
                    " Teacher INTEGER, " +
                    " MaxEnrollment INTEGER, " +
                    " Students INTEGER, " +
                    " Credits INTEGER, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table Course in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableStudent(){
        try(Connection conn = DriverManager.getConnection(DB_URL_Final, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE Student " +
                    "(id INTEGER not NULL, " +
                    " FirstName VARCHAR(255), " +
                    " LastName VARCHAR(255), " +
                    " TotalCredits INTEGER, " +
                    " Course INTEGER, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table Student in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableTeacher(){
        try(Connection conn = DriverManager.getConnection(DB_URL_Final, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE Teacher " +
                    "(id INTEGER not NULL, " +
                    " FirstName VARCHAR(255), " +
                    " LastName VARCHAR(255), " +
                    " Course INTEGER, " +
                    " PRIMARY KEY ( id ), " +
                    " FOREIGN KEY (Course) REFERENCES Course(id))";

            stmt.executeUpdate(sql);
            System.out.println("Created table Teacher in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addFKStudentCourses(){
        try(Connection conn = DriverManager.getConnection(DB_URL_Final, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "ALTER TABLE Student ADD FOREIGN KEY (Course) REFERENCES Course(id)";

            stmt.executeUpdate(sql);
            System.out.println("Added Foreign Key Constraint");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFKCourseEnrolledStudents(){
        try(Connection conn = DriverManager.getConnection(DB_URL_Final, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "ALTER TABLE Course ADD FOREIGN KEY (Students) REFERENCES Student(id)";

            stmt.executeUpdate(sql);
            System.out.println("Added Foreign Key Constraint");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
