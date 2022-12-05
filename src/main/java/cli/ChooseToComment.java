package cli;

import entities.Course;
import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.CourseDataAccessInterface;
import usecase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class ChooseToComment implements ChooseToCommentInterface{
    @Override
    public void displayChooseComment(Presenter presenter) {
        presenter.outputMessage("Would you like your review to have a comment? (Y/N)");
    }
    @Override
    public void addReviewChooser(Scanner scanner, Scanner scanner2, Course course, Controller controller, Presenter presenter,
                                 CourseDataAccessInterface database, WelcomeMenuInterface welcomeMenuInterface) throws
            IOException, ClassNotFoundException, InvalidInputException {
        String choice = scanner.nextLine();
        AddReviewInterface addReviewInterface = new AddReview();
        if (choice.equals("Y")) {addReviewInterface.addReviewComment(scanner, scanner2, course, controller, presenter,
                database, welcomeMenuInterface);
        } else if (choice.equals("N")) {
            addReviewInterface.addReview(scanner, course, controller, presenter, database, welcomeMenuInterface);

        } else {
            presenter.outputMessage("Please enter Y for yes or N for no");
            this.addReviewChooser(scanner, scanner2, course, controller, presenter, database, welcomeMenuInterface);
        }
    }
}