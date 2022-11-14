package UseCase;

import Entities.Comment;

public interface InputBoundary {


    void addComment(Comment comment) throws InvalidInputException;
    void editComment(int commentNum, String s) throws InvalidInputException, CommentNotInListException;
    void outputMessage(String s);

}
