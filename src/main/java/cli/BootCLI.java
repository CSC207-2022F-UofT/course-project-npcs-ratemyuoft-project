package cli;

import courseDataBase.CourseDataAccess;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewUseCase.CourseDataAccessInterface;
import leaveReviewUseCase.LeaveReviewInputBoundary;
import leaveReviewUseCase.LeaveReviewInteractor;
import leaveReviewUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is the class that creates all the needed interfaces and calls the welcome menu. This class is only called
 * by using BootCLI interface in Main class.
 */
public class BootCLI implements BootCLIInterface {
    @Override
    public void boot() throws IOException, ClassNotFoundException, InvalidInputException {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        LeaveReviewInterface registerInterface = new LeaveReview();
        LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface = new LeaveReviewLeaveReviewWelcomeMenu();
        LeaveReviewPresenter leaveReviewPresenter = new LeaveReviewPresenter();
        CourseDataAccessInterface dataAccess = new CourseDataAccess();
        dataAccess.generateTempCourses2();
        LeaveReviewInputBoundary leaveReviewInputBoundary =new LeaveReviewInteractor(leaveReviewPresenter,dataAccess);
        LeaveReviewController leaveReviewController = new LeaveReviewController(leaveReviewInputBoundary);

        leaveReviewWelcomeMenuInterface.displayCoursesToReview(leaveReviewPresenter, dataAccess);
        leaveReviewWelcomeMenuInterface.chooseCourseToReview(scanner,scanner2, leaveReviewController, leaveReviewPresenter, registerInterface, dataAccess);


    }
}
