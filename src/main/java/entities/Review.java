package entities;

import java.util.HashMap;
import java.util.Map;


public class Review {

    public Course course_reviewed;
    public int rating;

    public int numberOfLikes = 0;

    public String optionalComment;

    public int numberOfDislikes= 0 ;

    public Map<User,Comment > comments= new HashMap<>();

    public Review(int rating){
        this.rating = rating;
    }

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
    //Setters

    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setOptionalComment(String optionalComment) {
        this.optionalComment = optionalComment;
    }
}
