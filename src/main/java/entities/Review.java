package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Review implements Serializable {

    /**
     * This is the review class with is a review object that is made to critisize or praise a course within our database
     */

    private final Course course_reviewed;
    private int rating;

    private String reviewID;

    private int numberOfLikes = 0;

    private String optionalComment;

    private int numberOfDislikes= 0 ;

    private Map<User,Comment > comments= new HashMap<>();


    //Constructors 1st one for having no comment, just a rating and the 2nd one is for review with comment
    public Review(Course c, int rating){
        this.course_reviewed = c;
        this.rating = rating;
    }

    public Review(Course c, int rating, String optionalComment){
        this.course_reviewed = c;
        this.rating = rating;
        this.optionalComment = optionalComment;
    }
    //Getters

    public Course getCourse_reviewed(){
        return this.course_reviewed;
    }

    public int getRating(){
        return this.rating;

    }
    public int getNumberOfLikes(){
        return this.numberOfLikes;
    }
    public int getNumberOfDislikes(){
        return this.numberOfDislikes;
    }

    public String getOptionalComment() {
        return this.optionalComment;
    }

    public String getReviewID() {
        return this.reviewID;
    }
    //Setters

    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public void setRating(int r) {this.rating = r;}

    public void setReviewID(int i) {this.reviewID = course_reviewed.courseName + "Review" + Integer.toString(i);}
}
