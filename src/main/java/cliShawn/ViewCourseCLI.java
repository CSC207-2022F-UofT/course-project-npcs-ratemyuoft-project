package cliShawn;

import java.io.IOException;
import java.util.Scanner;

import courseDatabase.CourseDataAccessShawn;
import viewCourseInterfaceAdapters.ViewCourseController;
import viewCourseInterfaceAdapters.ViewCoursePresenter;
import viewCourseReviewUseCase.CourseDataAccessInterface;
import viewCourseReviewUseCase.ViewCourseInputBoundary;
import viewCourseReviewUseCase.ViewCourseOutputBoundary;
import viewCourseReviewUseCase.ViewCourseInteractor;
import loginUseCase.InvalidInputException;

public class ViewCourseCLI {
    public void viewcourse(Scanner scanner) throws IOException, ClassNotFoundException, InvalidInputException {
        ViewCourseOutputBoundary presenter = new ViewCoursePresenter();
        CourseDataAccessInterface dataaccess = new CourseDataAccessShawn();
        ViewCourseInputBoundary viewcourse = new ViewCourseInteractor(dataaccess, presenter);
        ViewCourseController viewCourseController = new ViewCourseController(viewcourse);

        System.out.println("Enter Course Name Please = > " + "\n");

        try {
            viewCourseController.DisplayReviews(scanner.next());

        } catch (Exception e) {
            System.out.println("Try Again");
        }
    }
}
