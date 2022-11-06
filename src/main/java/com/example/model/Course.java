package com.example.model;

import javax.persistence.*;

@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "course_id")
    private long courseID;
    @Column(name="course_name")
    private String courseName;
    @Column(name="course_prof")
    private String courseProf;

    public Course() {
    }

    public Course(long courseId, String courseName, String courseProf) {
        this.courseID = courseId;
        this.courseName = courseName;
        this.courseProf = courseProf;
    }

    public Course(String courseName, String courseProf) {
        this.courseName = courseName;
        this.courseProf = courseProf;
    }

    public long getcourseID() {
        return this.courseID;
    }

    public String getcourseName() {
        return this.courseName;
    }

    public String getProfessor() {
        return this.courseProf;
    }

    public void setcourseID(long courseID) {
        this.courseID = courseID;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setAuthor(String courseProf) {
        this.courseProf = courseProf;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + this.courseID +
                ", courseName='" + this.courseName + '\'' +
                ", courseProfessor='" + this.courseProf + '\'' +
                '}';
    }
}
