package cli;

import java.io.IOException;
import java.util.Scanner;

import courseDataBase.CourseDataAccessInterface;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewUseCase.InvalidInputException;


public interface LeaveReviewChooseToCommentInterface {

    void displayChooseComment(LeaveReviewPresenter leaveReviewPresenter);

    void addReviewChooser(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter,
                          CourseDataAccessInterface database, LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface)
            throws IOException, ClassNotFoundException, InvalidInputException;
}
