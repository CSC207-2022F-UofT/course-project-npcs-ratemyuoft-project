package leaveReviewUseCase;

import java.io.IOException;

import entities.Course;
import entities.Review;

public interface LeaveReviewInputBoundary {
    void addReview(Course c, int r) throws InvalidInputException, IOException;

    void addReview(Course c, int r, String s) throws InvalidInputException, IOException;

    void outputMessage(String s);
}