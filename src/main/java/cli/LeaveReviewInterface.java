package cli;

import java.io.IOException;
import java.util.Scanner;

import dataBases.courseDataBase.CourseDataAccessInterface;
import interfaceAdapters.leaveReviewInterfaceAdapter.LeaveReviewController;
import interfaceAdapters.leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import useCases.leaveReviewUseCase.InvalidInputException;

public interface LeaveReviewInterface {

    void addReviewComment(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface dataaccess,
                          LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException;

    void addReview(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface dataaccess,
                   LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException;

}
