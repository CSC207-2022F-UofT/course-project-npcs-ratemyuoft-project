package InterfaceAdapter;

import DataStructures.InPutData;
import UseCase.CommentNotInListException;
import UseCase.InputBoundary;
import UseCase.InvalidInputException;

import java.io.IOException;

public class Controller {
    private final InputBoundary inputBoundary;
    private InPutData inPutData;

    /**
     * @param inputBoundary
     * Constructor
     */
    // Constructor
    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;

    }

    /**
     * @param message
     * Called by UI and goes to Interact to show message on presenter
     */
    public void outPutMessage(String message){
        inputBoundary.outputMessage(message);

    }

    /**
     * Called by UI and goes to Interact to show Output on presenter
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void showComments() throws IOException, ClassNotFoundException {
         inputBoundary.showComments();
    }

    /** Called by UI and send a String to Interact
     * @param comment
     * @throws IOException
     * @throws InvalidInputException
     */
    public void addComment(String comment) throws IOException, InvalidInputException {
        try {
            inPutData = new InPutData(comment);
            inputBoundary.addComment(inPutData);
        } catch (InvalidInputException e) {
            throw new InvalidInputException();
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
