package Entities;

import java.util.ArrayList;


public class Course {
    public String courseName;

    public ArrayList<Review> reviews= new ArrayList<Review>();

    public double courseRaiting = 0.0;
    public String fieldOfStudy;

    //Constructor

    public Course(String courseName,String fieldOfStudy){
        this.courseName = courseName;
        this.fieldOfStudy = fieldOfStudy;
    }

    //Getters


    public String getCourseName() {
        return this.courseName;
    }

    public String getFieldOfStudy() {
        return this.fieldOfStudy;
    }

    public double getCourseRaiting() {
        return this.courseRaiting;
    }

    //Setters


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseRaiting(double courseRaiting) {
        this.courseRaiting = courseRaiting;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}
