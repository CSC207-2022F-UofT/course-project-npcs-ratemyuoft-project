package entities;

import java.io.Serializable;

public class Comment implements Serializable {
    private final int commentNum  ;
    private Review review;
    private String comment;
    private static int count = 1 ;


    /**
     * @param comment
     * Comment class Constructor
     */
    public Comment(String comment) {
        this.commentNum = count ++;
        this.comment = comment;
    }

    /**
     * @return
     * To string method
     */
    public String toString(){
        return ("ID :" + this.commentNum + " Comment: " + this.comment);
    }
    /**
     * @return comment number(ID)
     * Getter for a comment ID
     */
    public int getCommentNum() {return this.commentNum;}

    /**
     * @return String
     * Gather for comment ass a string
     */
    public String getComment() {return this.comment;}

    /**
     * @param comment
     * set comment
     */
    public void setComment(String comment) {this.comment = comment;}

    /**
     * Reset count to zero only used for testing
     */
    public static void resetCount(){
        count = 1;
    }








}
