package InterfaceAdapter;

import Entities.Comment;
import Entities.CommentList;
import UseCase.CommentNotInListException;
import UseCase.InputBoundary;
import UseCase.InvalidInputException;

import java.io.IOException;

public class Controller {
    private final InputBoundary inputBoundary;

    // Constructor
    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;

    }

    public CommentList showComments() throws IOException, ClassNotFoundException {
        return inputBoundary.showComments();

    }

    public void addComment(String comment) throws IOException, InvalidInputException {
        try {
            inputBoundary.addComment(comment);
        } catch (InvalidInputException e) {
            InvalidInputException InvalidInputException = null;
            throw InvalidInputException;
        }catch (IOException e){

            throw new IOException();

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
