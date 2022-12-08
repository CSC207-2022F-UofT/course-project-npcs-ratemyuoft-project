package useCases.leaveReviewUseCase;

import java.io.IOException;

/**
 * LeaveReviewInputBoundary is an interface that is used by LeaveReviewController to call needed methods from the
 * Interactor in order to remove dependency and follow clean architecture.
 */
public interface LeaveReviewInputBoundary {

    /**
     *
     * @param leaveReviewCourseRequestModel This is the request model that contains the name of the course we intend on
     *                                      adding a review to.
     * @param leaveReviewRatingRequestModel This is the request model that contains the rating of the review.
     * @throws InvalidInputException This exception is raised when an in valid input is inserting in the request models.
     * @throws IOException This exception is raised with the intent of debugging the code in case something goes wrong.
     * It is not seen by the end user.
     * @throws ClassNotFoundException This exception is also raised with the intent of debugging the code.
     */
    void addReview(LeaveReviewCourseRequestModel leaveReviewCourseRequestModel,
                   LeaveReviewRatingRequestModel leaveReviewRatingRequestModel) throws
            InvalidInputException, IOException, ClassNotFoundException;

    /**
     *
     * @param leaveReviewCourseRequestModel This is the request model that contains the name of the course we intend on
     *                                      adding a review to.
     * @param leaveReviewRatingRequestModel This is the request model that contains the rating of the review.
     * @param leaveReviewCommentRequestModel This is the request model that contains the comment of the review.
     * @throws InvalidInputException This exception is raised when an in valid input is inserting in the request models.
     * @throws IOException This exception is raised with the intent of debugging the code in case something goes wrong.
     * It is not seen by the end user.
     * @throws ClassNotFoundException This exception is also raised with the intent of debugging the code.
     * @throws InvalidCommentLengthException This exception is thrown when the comment in the
     * leaveReviewCommentRequestModel violates the set input boundaries.
     */
    void addReview(LeaveReviewCourseRequestModel leaveReviewCourseRequestModel,
                   LeaveReviewRatingRequestModel leaveReviewRatingRequestModel,
                   LeaveReviewCommentRequestModel leaveReviewCommentRequestModel) throws
            InvalidInputException, IOException, ClassNotFoundException, InvalidCommentLengthException;

}