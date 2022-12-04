package entities;
import java.io.Serializable;
import java.util.ArrayList;



public class Course implements Serializable{
    // A Course with a name, list of reviews, rating, and field of study.
    public String courseName;

    public ArrayList<Review> reviews= new ArrayList<>();

    public double courseRating = 0.0;
    public String fieldOfStudy;

    //Constructor

    public Course(String courseName,String fieldOfStudy){
        this.courseName = courseName;
        this.fieldOfStudy = fieldOfStudy;
    }

    public void AddReview(Review r){
        reviews.add(r);
    }
    //Getters


    public String getCourseName() {
        return this.courseName;
    }

    public String getFieldOfStudy() {
        return this.fieldOfStudy;
    }

    public double getCourseRating() {
        return this.courseRating;
    }

    public ArrayList<Review> GetReviews(){
        return this.reviews;
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
}
