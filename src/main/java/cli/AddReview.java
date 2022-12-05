package cli;

import java.io.IOException;
import java.util.Scanner;

import entities.Course;
import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.CourseDataAccessInterface;
import usecase.InvalidInputException;

public class AddReview implements AddReviewInterface {

    @Override
    public void addReview(Scanner scanner, Course course, Controller controller, Presenter presenter, CourseDataAccessInterface dataaccess,
                          WelcomeMenuInterface welcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException {

        presenter.outputMessage(" Give this course a rating for 0 to 5"+ "\n");
        int rating = scanner.nextInt();

        try{
            controller.addReview(course, rating);
            presenter.outputMessage("Your review has been added!");

        }catch (InvalidInputException e){
            presenter.outputMessage("Invalid Input!");
            welcomeMenuInterface.displayCoursesToReview(presenter, dataaccess);
        }


    }
    public void addReviewComment(Scanner scanner, Scanner scanner2, Course course, Controller controller, Presenter presenter, CourseDataAccessInterface dataaccess,
                                 WelcomeMenuInterface welcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException {
        presenter.outputMessage(" Give this course a rating for 0 to 5"+ "\n");
        int rating = scanner.nextInt();
        presenter.outputMessage("Enter your comment for this review");
        String c = scanner2.nextLine();

        try{
            controller.addReview(course, rating, c);
            presenter.outputMessage("Your review has been added!");

        }catch (InvalidInputException e){
            presenter.outputMessage("Invalid Input!");
            welcomeMenuInterface.displayCoursesToReview(presenter, dataaccess);
        }
    }
}
