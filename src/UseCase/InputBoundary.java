package UseCase;

import Entities.Comment;

public interface InputBoundary {

    boolean checkInput(Comment comments);
    void addComment(Comment comment) throws InvalidInputException;
    //void editcomment(Comment comments);

}
