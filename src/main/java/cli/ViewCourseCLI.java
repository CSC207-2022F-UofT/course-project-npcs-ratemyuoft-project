package cli;

import java.io.IOException;
import java.util.Scanner;

import courseDatabase.DataAccess;
import viewCourseInterfaceAdapters.Controller;
import viewCourseInterfaceAdapters.Presenter;
import viewCourseReviewUseCase.Gateway;
import viewCourseReviewUseCase.InputBoundary;
import viewCourseReviewUseCase.OutputBoundary;
import viewCourseReviewUseCase.ViewCourse;
import loginUseCase.InvalidInputException;

public class ViewCourseCLI {
    public void viewcourse(Scanner scanner) throws IOException, ClassNotFoundException, InvalidInputException {
        OutputBoundary presenter = new Presenter();
        Gateway dataaccess = new DataAccess();
        InputBoundary viewcourse = new ViewCourse(dataaccess, presenter);
        Controller controller = new Controller(viewcourse);

        System.out.println("Enter Course Name Please = > " + "\n");

        try {
            controller.DisplayReviews(scanner.next());

        } catch (Exception e) {
            System.out.println("Try Again");
        }
    }
}
