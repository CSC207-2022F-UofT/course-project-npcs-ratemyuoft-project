package cli;

import courseDataBase.CourseDataAccess;
import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.CourseDataAccessInterface;
import usecase.InputBoundary;
import usecase.Interactor;
import usecase.InvalidInputException;

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
        AddReviewInterface registerInterface = new AddReview();
        WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
        Presenter presenter = new Presenter();
        CourseDataAccessInterface dataAccess = new CourseDataAccess();
        dataAccess.generateTempCourses2();
        InputBoundary inputBoundary =new Interactor(presenter,dataAccess);
        Controller controller = new Controller(inputBoundary);

        welcomeMenuInterface.displayCoursesToReview(presenter, dataAccess);
        welcomeMenuInterface.chooseCourseToReview(scanner,scanner2, controller,presenter, registerInterface, dataAccess);


    }
}
