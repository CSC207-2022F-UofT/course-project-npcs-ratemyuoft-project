package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the review class which is a review object that is made to review a course within our database
 */
public class Review implements Serializable {

    /**
     * This is the course that is being reviewed.
     */
    private final Course course_reviewed;

    /**
     * This is the rating that the person reviewing the course decided to give.
     */
    private int rating;

    /**
     * If the user decided to give this course a review with a comment, then this is where the comment would be stored
     * within review.
     */
    private String optionalComment;

    /**
     * This is the unique ID of the review given to the course inorder to correctly identify each review.
     */
    private String reviewID;

    /**
     * this is the number of likes that a review starts of with (0).
     */
    private int numberOfLikes = 0;

    /**
     * This is the number of dislikes that the review starts of with (0).
     */
    private int numberOfDislikes= 0 ;


    // Constructors
    // 1st one for having no comment, just a rating and the 2nd one is for review with comment
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

    /**
     * This getter returns the course that the review is being added to.
     */
    public Course getCourse_reviewed(){
        return this.course_reviewed;
    }

    /**
     * This getter returns the rating that this review has.
     */
    public int getRating(){
        return this.rating;

    }

    /**
     * This getter returns the number of likes that this review currently has.
     */
    public int getNumberOfLikes(){
        return this.numberOfLikes;
    }

    /**
     * This getter returns the number of dislikes that this review currently has.
     */
    public int getNumberOfDislikes(){
        return this.numberOfDislikes;
    }
    /**
     * This getter returns the OptionalComment that this review has if it has a comment.
     */
    public String getOptionalComment() {
        return this.optionalComment;
    }
    /**
     * This getter returns the uniqueID of this review.
     */
    public String getReviewID() {
        return this.reviewID;
    }
    //Setters

    /**
     * This setter sets the number of dislikes of the review to the parameter.
     */
    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    /**
     * This setter sets the number of likes of the review to the parameter.
     */
    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    /**
     * This setter sets the rating of the review to the parameter.
     */
    public void setRating(int r) {this.rating = r;}

    /**
     * This setter sets the reviewID of the review depending on the name of the course that is being reviewed and the
     * number of reviews the course currently has.
     */
    public void setReviewID(int i) {this.reviewID = course_reviewed.getCourseName() + "Review" + Integer.toString(i);}
}
