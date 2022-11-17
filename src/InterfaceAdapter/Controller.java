package InterfaceAdapter;

import Entities.Comment;
import UseCase.CommentNotInListException;
import UseCase.InputBoundary;
import UseCase.InvalidInputException;

public class Controller {
    private final InputBoundary inputBoundary;

    // Constructor
    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void showComments(){
        inputBoundary.showComments();
    }

    public void addComment(Comment comment)  {
        try {
            inputBoundary.addComment(comment);
        } catch (InvalidInputException e) {
            inputBoundary.outputMessage("InvalidInput");
        }

    }
    public void editComment(int commentNum, String s){
        try {
            inputBoundary.editComment(commentNum,s);
        } catch (InvalidInputException e) {
            inputBoundary.outputMessage("Invalid Input");
        } catch (CommentNotInListException e) {
            inputBoundary.outputMessage("Comment Not In List");
        }


    }

}
