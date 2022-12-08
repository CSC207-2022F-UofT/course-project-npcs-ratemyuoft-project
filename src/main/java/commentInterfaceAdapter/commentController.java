package commentInterfaceAdapter;

import commentDataStructures.commentInPutData;
import commentUseCase.commentInputBoundary;
import commentUseCase.InvalidInputException;

import java.io.IOException;

public class commentController {
    private final commentInputBoundary commentInputBoundary;


    /**
     * @param commentInputBoundary Constructor
     */
    // Constructor
    public commentController(commentInputBoundary commentInputBoundary) {
        this.commentInputBoundary = commentInputBoundary;

    }

    /**
     * @param message Called by UI and goes to Interact to show message on presenter
     */
    public void outPutMessage(String message) {
        commentInputBoundary.outputMessage(message);

    }

    /**
     * Called by UI and goes to Interact to show Output on presenter
     * @throws IOException import fail
     * @throws ClassNotFoundException class no found
     */
    public void showComments() throws IOException, ClassNotFoundException {
        commentInputBoundary.showComments();
    }

    /**
     * Called by UI It will turn a string into an input data and send it to the interactor
     *
     * @param comment String
     * @throws IOException import fail
     * @throws InvalidInputException invalid input
     */
    public void addComment(String comment) throws IOException, InvalidInputException {
        try {
            commentInPutData commentInPutData = new commentInPutData(comment);
            commentInputBoundary.addComment(commentInPutData);
        } catch (InvalidInputException e) {
            throw new InvalidInputException();
        } catch (IOException e) {
            throw new IOException();

        }

    }

    }
