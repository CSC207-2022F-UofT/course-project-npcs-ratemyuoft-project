package cli;

import courseDataBase.CourseDataAccess;
import courseDataBase.CourseDataAccessInterface;
import entities.CourseList;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewUseCase.InvalidInputException;
import leaveReviewUseCase.LeaveReviewInputBoundary;
import leaveReviewUseCase.LeaveReviewInteractor;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LeaveReviewWelcomeMenu implements LeaveReviewWelcomeMenuInterface {

    @Override
    public void chooseCourseToReview(Scanner scanner, Scanner scanner2, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter,
                                     LeaveReviewInterface leaveReviewInterface,
                                     CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException, InvalidInputException {
        leaveReviewPresenter.outputMessage("Please enter the name of the course you want to review:" + "\n");
        String choice = scanner.nextLine();
        CourseList courseList = courseDataAccessInterface.importCourses();
        List<String> courseNames = courseList.getCourseNameList();
        if(courseNames.contains(choice)){
            LeaveReviewChooseToCommentInterface leaveReviewChooseToCommentInterface = new LeaveReviewChooseToComment();
            leaveReviewChooseToCommentInterface.displayChooseComment(leaveReviewPresenter);
            leaveReviewChooseToCommentInterface.addReviewChooser(scanner, scanner2, choice, leaveReviewController, leaveReviewPresenter,
                    courseDataAccessInterface, this);

        } else{
            leaveReviewPresenter.outputMessage("Invalid Input! Please choose a course in the list!" + "\n");
            this.chooseCourseToReview(scanner, scanner2, leaveReviewController, leaveReviewPresenter, leaveReviewInterface,
                    courseDataAccessInterface);
        }
    }
}
