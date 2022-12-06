package cli;

import java.io.IOException;
import java.util.Scanner;

import entities.Course;
import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.CourseDataAccessInterface;
import usecase.InvalidInputException;


public interface ChooseToCommentInterface {

    void displayChooseComment(Presenter presenter);

    void addReviewChooser(Scanner scanner, Scanner scanner2, String course, Controller controller, Presenter presenter,
                          CourseDataAccessInterface database, WelcomeMenuInterface welcomeMenuInterface)
            throws IOException, ClassNotFoundException, InvalidInputException;
}
