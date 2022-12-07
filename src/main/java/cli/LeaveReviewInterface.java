package cli;

import java.io.IOException;
import java.util.Scanner;

import courseDataBase.CourseDataAccessInterface;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewUseCase.InvalidInputException;

public interface LeaveReviewInterface {

    void addReviewComment(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface dataaccess,
                          LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException;

    void addReview(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface dataaccess,
                   LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException;

}
