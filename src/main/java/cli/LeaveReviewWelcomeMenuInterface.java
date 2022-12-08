package cli;

import dataBases.courseDataBase.CourseDataAccessInterface;
import interfaceAdapters.leaveReviewInterfaceAdapter.LeaveReviewController;
import interfaceAdapters.leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import useCases.leaveReviewUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface LeaveReviewWelcomeMenuInterface {

    void chooseCourseToReview(Scanner scanner, Scanner scanner2, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter,
                              LeaveReviewInterface leaveReviewInterface,
                              CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException, InvalidInputException;

}
