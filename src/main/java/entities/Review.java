package entities;
import java.io.Serializable;


import java.util.HashMap;
import java.util.Map;

public class Review implements Serializable{

    public String Name;

    public int Rating;

    public int numberOfLikes;

    public String Comment;

    public Map<User,String> comments= new HashMap<>();


    //Constructors 1st one for having no comment, just a raiting and the 2nd one is for review with comment
    public Review(int Rating, String Comment, String Name){
        this.Rating = Rating;
        this.Comment = Comment;
        this.Name = Name;
        this.numberOfLikes = 0;
    }
    //Getters
    public int getRating(){
        return this.Rating;
    }
    public int getNumberOfLikes(){
        return this.numberOfLikes;
    }

    public String getComment() {
        return this.Comment;
    }
    //Setters

    public void Like() {
        this.numberOfLikes += 1;
    }

    public void setRating(int rating) {
        this.Rating = rating;
    }

    public void setComment(String comment) {
        this.Comment = comment;
    }
}