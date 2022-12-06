package interfaceadapter;

import entities.Course;
import usecase.InvalidCommentLengthException;
import usecase.InvalidInputException;
import usecase.InputBoundary;

import java.io.IOException;

/**
 * Controller class is used to communicate with inputBoundary interface. It is a starting point for information that is
 * passed from UI to back end through the interface. That is why it is packaged as interfaceAdapter.
 *
 */

public class Controller {
    private final InputBoundary inputBoundary;

    //Constructor
    public Controller(InputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * This method tries to pass the addReview method call to inputBoundary if no comment made with the review,
     * and catches Exceptions if they are thrown.
     */
    public void addReview(String c, String r) throws IOException, InvalidInputException {
        try {
            inputBoundary.addReview(c, r);
        } catch (InvalidInputException | ClassNotFoundException e) {
            throw new InvalidInputException();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * This method tries to pass the addReview method call to inputBoundary if there is a comment made with the review,
     * and catches Exceptions if they are thrown.
     */
    public void addReview(String c, String n, String s) throws IOException, InvalidInputException, InvalidCommentLengthException {
        try {
            inputBoundary.addReview(c, n, s);
        } catch (InvalidInputException | ClassNotFoundException e) {
            throw new InvalidInputException();
        } catch (IOException e) {
            throw new IOException();
        }
    }
}