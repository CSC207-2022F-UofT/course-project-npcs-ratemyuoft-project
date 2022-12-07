package cli;

import courseDataBase.CourseDataAccessInterface;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class LeaveReviewChooseToComment implements LeaveReviewChooseToCommentInterface {
    @Override
    public void displayChooseComment(LeaveReviewPresenter leaveReviewPresenter) {
        leaveReviewPresenter.outputMessage("Would you like your review to have a comment? (Y/N)" + "\n");
    }
    @Override
    public void addReviewChooser(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter,
                                 CourseDataAccessInterface database, LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface) throws
            IOException, ClassNotFoundException, InvalidInputException {
        String choice = scanner.nextLine();
        LeaveReviewInterface leaveReviewInterface = new LeaveReview();
        if (choice.equals("Y")) {
            leaveReviewInterface.addReviewComment(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter,
                database, leaveReviewWelcomeMenuInterface);
        } else if (choice.equals("N")) {
            leaveReviewInterface.addReview(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter, database, leaveReviewWelcomeMenuInterface);

        } else {
            leaveReviewPresenter.outputMessage("Invalid Input!" + "\nPlease enter Y for yes or N for no!" + "\n");
            this.displayChooseComment(leaveReviewPresenter);
            this.addReviewChooser(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter, database, leaveReviewWelcomeMenuInterface);
        }
    }
}