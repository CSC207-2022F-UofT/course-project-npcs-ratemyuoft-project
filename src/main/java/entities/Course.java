package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Course is the core entity in our RateMyUofT system application.
 * <p>
 *     Course is the structure that holds the application. It stores course information. And it contains its reviews.
 * </p>
 *
 */
public class Course implements Serializable {
    /**
     * Course has four instance variables.
     * <p>
     * courseName: String
     * <p>
     * reviews: Arraylist<Reviews>
     * <p>
     * courseRating: double
     * <p>
     * fieldOfStudy: String
     */
    public String courseName;
    public ArrayList<Review> reviews= new ArrayList<>();
    public double courseRating = 0.0;
    public String fieldOfStudy;

    /**
     * the constructor of an instance of Course class takes in a String and another String passed in as the courseName and
     * fieldOfStudy respectively.
     * @param courseName passed in as courseName
     * @param fieldOfStudy passed in as fieldOfStudy.
     */
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
    public ArrayList<Review> getReviews() { return reviews;}

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
    public void addReview(Review r) {
        reviews.add(r);
    }
}