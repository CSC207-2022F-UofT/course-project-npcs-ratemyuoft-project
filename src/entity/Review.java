package entity;


import java.util.HashMap;
import java.util.Map;

public class Review {

    public int raitingOfTheCourse;

    public int numberOfLikes = 0;

    public String optionalComment;

    public int numberOfDislikes= 0 ;

    public Map<Student,String > comments= new HashMap<>();

    //Constructors 1st one for having no comment, just a raiting and the 2nd one is for review with comment
    public Review(int raitingOfTheCourse){
        this.raitingOfTheCourse = raitingOfTheCourse;
    }

    public Review(int raitingOfTheCourse, String optionalComment){
        this.raitingOfTheCourse = raitingOfTheCourse;
        this.optionalComment = optionalComment;
    }
    //Getters

    public int getRaitingOfTheCourse(){
        return this.raitingOfTheCourse;

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

    public void setRaitingOfTheCourse(int raitingOfTheCourse) {
        this.raitingOfTheCourse = raitingOfTheCourse;
    }

    public void setOptionalComment(String optionalComment) {
        this.optionalComment = optionalComment;
    }
}
