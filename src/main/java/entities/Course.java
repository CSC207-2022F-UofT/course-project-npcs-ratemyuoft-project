package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Course is the core entity in our RateMyUofT system application.
 * Course is the structure that holds the application. It stores course information. And it contains its reviews.
 */
public class Course implements Serializable {

    /**
     * This is the name of the course.
     */
    private String courseName;

    /**
     * This is the list of reviews that this course currently has.
     */
    private final ArrayList<Review> reviews= new ArrayList<>();

    /**
     * This the rating that this course has which is based on how good or bad its reviews are.
     */
    private double courseRating = 0.0;

    /**
     * This is the academic area that this course is on (Field of Study).
     */
    private String fieldOfStudy;

    /**
     * This is the total ratings that this course has form its reviews. This is used to calculate the course's
     * (average) rating.
     */
    private int ratingCount;

    /**
     * This is the number of reviews that this course has. This is used to calculate the course's (average) rating
     * and to assign unique ReviewIDs to the reviews of this course.
     */
    private int reviewCount = 0;

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

    /**
     * This getter returns the name of the course.
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * This getter returns the field of study that this course is in.
     */
    public String getFieldOfStudy() { return this.fieldOfStudy; }

    /**
     * This getter returns the rating of this course.
     */
    public double getCourseRating() { return this.courseRating; }

    /**
     * This getter returns the list of reviews that this course has.
     */
    public ArrayList<Review> getReviews() { return reviews;}

    /**
     * This getter returns the total number of reviews that this course has.
     */
    public int getReviewCount() {
        return reviewCount;
    }

    /**
     * This getter returns the total of ratings from all of this course's reviews.
     */
    public int getRatingCount() {return ratingCount;}

    //Setters

    /**
     * This setter sets the name of the course to what is the parameter.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * This setter sets the rating of the course to what is the parameter.
     */
    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    /**
     * This setter sets the field of study of the course to what is the parameter.
     */
    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    /**
     * This method adds a review object to the course and also updates the reviewCount, rating count and course rating
     * of the course.
     */
    public void addReview(Review r) {
        ratingCount+= r.getRating();
        reviewCount += 1;
        r.setReviewID(reviewCount);
        reviews.add(r);
        courseRating = (float)ratingCount/(float)reviewCount;
    }

}
