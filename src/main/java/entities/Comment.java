package entities;

public class Comment {
    private int commentNum;
    private User user;
    private String comment;
    private static int count;

    /**
     * This is the reviewID of the review that this comment is being added to.
     */
    private String CommentingReviewsID;


    public Comment(String comment) {
        this.commentNum = count ++;
    }

    /**
     * This method returns the ReviewID of the review that this comment is being added to.
     */
    public String getCommentingReviewsID() {
        return CommentingReviewsID;
    }

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public int getCommentNum() {return commentNum;}

    public static int getCount() {return count;}

    public static void setCount(int count) {Comment.count = count;}

    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}

    @Override
    public boolean equals(Object obj) {
        return this.comment.equals(obj);
    }





}
