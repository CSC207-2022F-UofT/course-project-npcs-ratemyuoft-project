package Entities;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentNum ;
    private User user;
    private String comment;
    private static int count;


    public Comment(String comment) {
        this.commentNum = ++ count ;
        this.comment = comment;
    }

    public String toString(){
        return "ID :" + commentNum + " Comment: " +comment;
    }
    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public int getCommentNum() {return commentNum;}

    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}









}
