package cli;

import java.io.IOException;
import java.util.Scanner;
import dataBases.courseDataBase.CourseDataAccess;
import dataBases.courseDataBase.CourseDataAccessInterface;
import interfaceAdapters.likeReviewInterfaceAdapters.LikeReviewController;
import interfaceAdapters.likeReviewInterfaceAdapters.LikeReviewPresenter;
import useCases.likeReviewUseCase.LikeReviewInputBoundary;
import useCases.likeReviewUseCase.LikeReviewInteractor;
import useCases.likeReviewUseCase.LikeReviewOutputBoundary;
import useCases.logInUseCase.InvalidInputException;
import interfaceAdapters.viewCourseInterfaceAdapters.ViewCourseController;
import interfaceAdapters.viewCourseInterfaceAdapters.ViewCoursePresenter;
import useCases.viewCourseReviewUseCase.ViewCourseInputBoundary;
import useCases.viewCourseReviewUseCase.ViewCourseOutputBoundary;
import useCases.viewCourseReviewUseCase.ViewCourseInteractor;

public class ViewCourseCLI {
    public void viewcourse(Scanner scanner) throws ClassNotFoundException, InvalidInputException, IOException, useCases.leaveReviewUseCase.InvalidInputException {
        ViewCourseOutputBoundary presenter = new ViewCoursePresenter();
        CourseDataAccessInterface dataaccess = new CourseDataAccess();
        ViewCourseInputBoundary viewcourse = new ViewCourseInteractor(dataaccess, presenter);
        ViewCourseController viewCourseController = new ViewCourseController(viewcourse);
        System.out.println("Please enter the course you want to view:");
        String name = scanner.next();

        viewCourseController.DisplayReviews(name);

        ReviewMenu reviewMenu = new ReviewMenu();
        reviewMenu.displayFilterOptions();
        CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccess();
        LikeReviewOutputBoundary likeReviewOutputBoundary = new LikeReviewPresenter();
        LikeReviewInputBoundary likeReviewInputBoundary = new LikeReviewInteractor(courseDataAccessInterface, likeReviewOutputBoundary);
        LikeReviewController likeReviewController = new LikeReviewController(likeReviewInputBoundary);
        Scanner scanner3 = new Scanner(System.in);
        reviewMenu.filter(scanner3, likeReviewController);
    }
}
