package leaveReviewUseCase;

import java.io.IOException;

public interface LeaveReviewInputBoundary {
    void addReview(String courseName, String rating) throws InvalidInputException, IOException, ClassNotFoundException;

    void addReview(String courseName, String rating, String comment) throws InvalidInputException, IOException, ClassNotFoundException, InvalidCommentLengthException;

}