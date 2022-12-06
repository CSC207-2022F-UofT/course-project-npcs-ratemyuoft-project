package cli;

import java.io.IOException;
import java.util.Scanner;

import entities.Course;
import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.CourseDataAccessInterface;
import usecase.InvalidInputException;

public interface AddReviewInterface {

    void addReviewComment(Scanner scanner, Scanner scanner2, String course, Controller controller, Presenter presenter, CourseDataAccessInterface dataaccess,
                          WelcomeMenuInterface welcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException;

    void addReview(Scanner scanner, Scanner scanner2,String course, Controller controller, Presenter presenter, CourseDataAccessInterface dataaccess,
                   WelcomeMenuInterface welcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException;

}
