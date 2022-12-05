package cli;

import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.CourseDataAccessInterface;
import usecase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface WelcomeMenuInterface {

    void displayCoursesToReview(Presenter presenter, CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException;

    void chooseCourseToReview(Scanner scanner, Scanner scanner2, Controller controller, Presenter presenter,
                                     AddReviewInterface addReviewInterface,
                              CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException, InvalidInputException;

}
