package Entities;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentNum  ;
    private User user;
    private String comment;
    private static int count = 1 ;


    public Comment(String comment) {

        this.commentNum = count ;
        System.out.println(this.count);
        this.comment = comment;
        System.out.println(count);
        count ++;
        System.out.println(count);
    }

    public String toString(){
        return ("ID :" + this.commentNum + " Comment: " +this.comment);
    }
    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public int getCommentNum() {return this.commentNum;}

    public String getComment() {return this.comment;}

    public void setComment(String comment) {this.comment = comment;}









}
