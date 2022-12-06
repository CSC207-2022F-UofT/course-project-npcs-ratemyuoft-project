package cli;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Course;
import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.CourseDataAccessInterface;
import usecase.InvalidInputException;

public class AddReview implements AddReviewInterface {

    @Override
    public void addReview(Scanner scanner, Scanner scanner2, String course, Controller controller, Presenter presenter, CourseDataAccessInterface dataaccess,
                          WelcomeMenuInterface welcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException {

        presenter.outputMessage("Give this course a rating from 0 to 5 stars"+ "\n");

        try{
            int rating = scanner.nextInt();
            controller.addReview(course, rating);
            presenter.outputMessage("Your review has been added!" + "\n");

        }catch (InvalidInputException e){
            presenter.outputMessage("Invalid Input! Please ensure your rating is between 0 and 5 inclusive!" + "\n");
            this.addReview(scanner, scanner2, course, controller, presenter, dataaccess, welcomeMenuInterface);

        }catch (InputMismatchException f) {
            presenter.outputMessage("Invalid Input! Please ensure that your rating is an integer!");
            this.addReview(scanner, scanner2, course, controller, presenter, dataaccess, welcomeMenuInterface);
        }


    }
    public void addReviewComment(Scanner scanner, Scanner scanner2, String course, Controller controller, Presenter presenter, CourseDataAccessInterface dataaccess,
                                 WelcomeMenuInterface welcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException {
        presenter.outputMessage("Give this course a rating from 0 to 5 stars"+ "\n");
        try{
            int rating = scanner.nextInt();
            presenter.outputMessage("Enter your comment for this review" + "\n");
            String c = scanner2.nextLine();
            controller.addReview(course, rating, c);
            presenter.outputMessage("Your review has been added!" + "\n");

        }catch (InvalidInputException e){
            presenter.outputMessage("Invalid Input! Please ensure that your rating is between 0 and 5 inclusive!" + "\n");
            this.addReviewComment(scanner, scanner2, course, controller, presenter, dataaccess, welcomeMenuInterface);

        }catch (InputMismatchException f) {
            presenter.outputMessage("Invalid Input! Please ensure that your rating is an Integer!");
            this.addReviewComment(scanner, scanner2, course, controller, presenter, dataaccess, welcomeMenuInterface);
        }
    }
}
