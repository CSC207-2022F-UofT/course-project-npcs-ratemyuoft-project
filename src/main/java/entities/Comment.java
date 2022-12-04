package entities;

public class Comment {
    private int commentNum;
    private User user;
    private String comment;
    private static int count;


    public Comment() {
        this.commentNum = count ++;
    }


    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public int getCommentNum() {return commentNum;}

    public void setCommentNum(int commentNum) {this.commentNum = commentNum;}

    public static int getCount() {return count;}

    public static void setCount(int count) {Comment.count = count;}

    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}

    @Override
    public boolean equals(Object obj) {
        return this.comment.equals(obj);
    }




}
