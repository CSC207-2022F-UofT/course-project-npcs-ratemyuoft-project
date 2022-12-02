package Entities;

import java.io.Serializable;

public class Comment implements Serializable {
    private final int commentNum  ;
    private User user;
    private String comment;
    private static int count = 1 ;


    public Comment(String comment) {
        this.commentNum = count ++;
        this.comment = comment;
        System.out.println(this.commentNum);
    }

    public String toString(){
        return ("ID :" + this.commentNum + " Comment: " + this.comment);
    }
    /**
     * @return comment number(ID)
     * getter
     */
    public int getCommentNum() {return this.commentNum;}

    public String getComment() {return this.comment;}

    public void setComment(String comment) {this.comment = comment;}

    public static void resetCount(){
        count = 1;
    }








}
