package cli;

import java.io.IOException;
import java.util.Scanner;
import courseDataBase.CourseDataAccess;
import courseDataBase.CourseDataAccessInterface;
import likeReviewInterfaceAdapters.LikeReviewController;
import likeReviewInterfaceAdapters.LikeReviewPresenter;
import likeReviewUseCase.LikeReviewInputBoundary;
import likeReviewUseCase.LikeReviewInteractor;
import likeReviewUseCase.LikeReviewOutputBoundary;
import logInUseCase.InvalidInputException;
import viewCourseInterfaceAdapters.ViewCourseController;
import viewCourseInterfaceAdapters.ViewCoursePresenter;
import viewCourseReviewUseCase.ViewCourseInputBoundary;
import viewCourseReviewUseCase.ViewCourseOutputBoundary;
import viewCourseReviewUseCase.ViewCourseInteractor;

public class ViewCourseCLI {
    public void viewcourse(Scanner scanner) throws ClassNotFoundException, InvalidInputException, IOException, leaveReviewUseCase.InvalidInputException {
        ViewCourseOutputBoundary presenter = new ViewCoursePresenter();
        CourseDataAccessInterface dataaccess = new CourseDataAccess();
        ViewCourseInputBoundary viewcourse = new ViewCourseInteractor(dataaccess, presenter);
        ViewCourseController viewCourseController = new ViewCourseController(viewcourse);
        System.out.println("Enter Course Name Please = > ");
        String name = scanner.next();

        viewCourseController.DisplayReviews(name);

        ReviewMenu reviewMenu = new ReviewMenu();
        reviewMenu.displayFilterOptions();
        CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccess();
        LikeReviewOutputBoundary likeReviewOutputBoundary = new LikeReviewPresenter();
        LikeReviewInputBoundary likeReviewInputBoundary = new LikeReviewInteractor(courseDataAccessInterface, likeReviewOutputBoundary);
        LikeReviewController likeReviewController = new LikeReviewController(likeReviewInputBoundary);
        reviewMenu.filter(scanner, likeReviewController);
    }
}
