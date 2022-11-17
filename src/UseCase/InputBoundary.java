package UseCase;

import Entities.Comment;

public interface InputBoundary {

    void showComments();
    void addComment(Comment comment) throws InvalidInputException;
    void editComment(int commentNum, String s) throws InvalidInputException, CommentNotInListException;
    void outputMessage(String s);

}
