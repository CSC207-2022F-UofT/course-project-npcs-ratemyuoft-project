package leaveReviewUseCase;

import java.io.IOException;

public interface LeaveReviewInputBoundary {
    void addReview(LeaveReviewCourseRequestModel leaveReviewCourseRequestModel,
                   LeaveReviewRatingRequestModel leaveReviewRatingRequestModel) throws
            InvalidInputException, IOException, ClassNotFoundException;

    void addReview(LeaveReviewCourseRequestModel leaveReviewCourseRequestModel,
                   LeaveReviewRatingRequestModel leaveReviewRatingRequestModel,
                   LeaveReviewCommentRequestModel leaveReviewCommentRequestModel) throws
            InvalidInputException, IOException, ClassNotFoundException, InvalidCommentLengthException;

}