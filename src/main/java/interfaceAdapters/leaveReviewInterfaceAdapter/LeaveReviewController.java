package interfaceAdapters.leaveReviewInterfaceAdapter;

import useCases.leaveReviewUseCase.*;

import java.io.IOException;

/**
 * LeaveReviewController class is used to communicate with leaveReviewInputBoundary interface. It is a starting point for information that is
 * passed from UI to back end through the interface. That is why it is packaged as interfaceAdapter.
 *
 */

public class LeaveReviewController {
    private final LeaveReviewInputBoundary leaveReviewInputBoundary;

    /**
     * The LeaveReviewController Constructor assigns the leaveReviewInputBoundary instance variable to the InputBoundary
     * in the parameter.
     */
    public LeaveReviewController(LeaveReviewInputBoundary leaveReviewInputBoundary) {
        this.leaveReviewInputBoundary = leaveReviewInputBoundary;
    }

    /**
     * This method tries to pass the addReview method call to leaveReviewInputBoundary if no comment made with the review,
     * and catches Exceptions if they are thrown.
     */
    public void addReview(String c, String r) throws IOException, InvalidInputException {
        try {
            leaveReviewInputBoundary.addReview(new LeaveReviewCourseRequestModel(c), new LeaveReviewRatingRequestModel(r));
        } catch (InvalidInputException | ClassNotFoundException e) {
            throw new InvalidInputException();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * This method tries to pass the addReview method call to leaveReviewInputBoundary if there is a comment made with the review,
     * and catches Exceptions if they are thrown.
     */
    public void addReview(String c, String n, String s) throws IOException, InvalidInputException, InvalidCommentLengthException {
        try {
            leaveReviewInputBoundary.addReview(new LeaveReviewCourseRequestModel(c), new LeaveReviewRatingRequestModel(n),
                    new LeaveReviewCommentRequestModel(s));
        } catch (InvalidInputException | ClassNotFoundException e) {
            throw new InvalidInputException();
        } catch (IOException e) {
            throw new IOException();
        }
    }
}