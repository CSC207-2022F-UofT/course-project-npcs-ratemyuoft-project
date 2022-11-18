package UseCase;

import Entities.Comment;
import Entities.CommentList;

public interface InputBoundary {

    CommentList showComments();
    void addComment(String comment) throws InvalidInputException;
    void editComment(int commentNum, String s) throws InvalidInputException, CommentNotInListException;
    void outputMessage(String s);

}
