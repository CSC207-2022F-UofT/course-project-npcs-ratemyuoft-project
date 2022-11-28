package entities;

import java.io.Serializable;
import java.util.ArrayList;


public class Course implements Serializable {
    public String courseName;

    public ArrayList<Review> reviews= new ArrayList<Review>();

    public double courseRating = 0.0;
    public String fieldOfStudy;

    //Constructor

    public Course(String courseName, String fieldOfStudy){
        this.courseName = courseName;
        this.fieldOfStudy = fieldOfStudy;
    }

    //Getters


    public String getCourseName() {
        return this.courseName;
    }

    public String getFieldOfStudy() { return this.fieldOfStudy; }

    public double getCourseRating() { return this.courseRating; }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    //Setters


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String toString(){
        return "Name: " + courseName + ", " + "Field of Studies: " + fieldOfStudy + ", Rating: " + courseRating;
    }

    public void addReview(Review r) {
        reviews.add(r);
    }
}
