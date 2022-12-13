package cli;

import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import courseDataBase.CourseDataAccessInterface;
import leaveReviewExceptions.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface LeaveReviewWelcomeMenuInterface {

    void displayCoursesToReview(LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException;

    void chooseCourseToReview(Scanner scanner, Scanner scanner2, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter,
                              LeaveReviewInterface leaveReviewInterface,
                              CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException, InvalidInputException;

}
