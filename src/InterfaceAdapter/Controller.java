package InterfaceAdapter;

import Entities.Comment;
import UseCase.InputBoundary;
import UseCase.InvalidInputException;

public class Controller {
    private final InputBoundary inputBoundary;

    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void addComment(Comment comment)  {
        try {
            inputBoundary.addComment(comment);
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }

    }

}
