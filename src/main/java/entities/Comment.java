package entities;

public class Comment {

    /**
     * This is the comment number of this comment
     */
    private int commentNum;

    /**
     * This is the User who has left this comment.
     */
    private User user;

    /**
     * This is the actual comment that this comment has.
     */
    private String comment;
    private static int count;

    /**
     * This constructor creates a new comment object with the comment instance variable assign to the parameter.
     */
    public Comment(String comment) {
        this.commentNum = count ++;
    }

    /**
     * This getter returns the User who created this comment.
     */
    public User getUser() {return user;}

    /**
     * This setter changes the User instance variable to the User in the parameter.
     */
    public void setUser(User user) {this.user = user;}

    /**
     * This getter returns the comment number of this comment.
     */
    public int getCommentNum() {return commentNum;}
    /**
     * This getter returns the count of this comment.
     */
    public static int getCount() {return count;}

    /**
     * This setter changes the count instance variable to the number in the parameter.
     */
    public static void setCount(int count) {Comment.count = count;}

    /**
     * This getter returns the comment details of this comment.
     */
    public String getComment() {return comment;}

    /**
     * This setter changes the comment instance variable to the string in the parameter.
     */
    public void setComment(String comment) {this.comment = comment;}

    /**
     *This method overrides the existing equals method by comparing strings based on their comment instance variable.
     */
    @Override
    public boolean equals(Object obj) {
        return this.comment.equals(obj);
    }





}
