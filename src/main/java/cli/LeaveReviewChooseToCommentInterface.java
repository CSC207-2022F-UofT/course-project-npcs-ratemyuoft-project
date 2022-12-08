package cli;

import java.io.IOException;
import java.util.Scanner;

import dataBases.courseDataBase.CourseDataAccessInterface;
import interfaceAdapters.leaveReviewInterfaceAdapter.LeaveReviewController;
import interfaceAdapters.leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import useCases.leaveReviewUseCase.InvalidInputException;


public interface LeaveReviewChooseToCommentInterface {

    void displayChooseComment(LeaveReviewPresenter leaveReviewPresenter);

    void addReviewChooser(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter,
                          CourseDataAccessInterface database, LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface)
            throws IOException, ClassNotFoundException, InvalidInputException;
}
