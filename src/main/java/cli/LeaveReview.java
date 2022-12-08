package cli;

import java.io.FilterInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import courseDataBase.CourseDataAccessInterface;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.FilterInputBoundary;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterUseCaseInteractor;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewUseCase.InvalidCommentLengthException;
import leaveReviewUseCase.InvalidInputException;

public class LeaveReview implements LeaveReviewInterface {

    @Override
    public void addReview(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface dataaccess,
                          LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException {

        leaveReviewPresenter.outputMessage("Give this course an integer rating from 0 to 5 stars:"+ "\n");

        String rating = scanner.nextLine();
        try{
            leaveReviewController.addReview(course, rating);
            leaveReviewPresenter.outputMessage("Your review has been added!" + "\n");
            FilterOutputBoundary filterOutputBoundary = new FilterPresenter();
            FilterInputBoundary filterInputBoundary = new FilterUseCaseInteractor(dataaccess, filterOutputBoundary);
            FilterController filterController =  new FilterController(filterInputBoundary);
            ViewCourseMenu viewCourseMenu = new ViewCourseMenu();
            viewCourseMenu.displayAfterFilterOptions();
            Scanner scanner3 = new Scanner(System.in);
            viewCourseMenu.chooseOptions(scanner3, filterController);

        }catch (InvalidInputException e){
            leaveReviewPresenter.outputMessage("Invalid Input! Please ensure your rating is between 0 and 5 inclusive!" + "\n");
            LeaveReviewInterface leaveReviewInterface = new LeaveReview();
            leaveReviewInterface.addReview(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter, dataaccess, leaveReviewWelcomeMenuInterface);

        }catch (InputMismatchException f) {
            leaveReviewPresenter.outputMessage("Invalid Input! Please ensure that your rating is an integer!" + "\n");
            LeaveReviewInterface leaveReviewInterface = new LeaveReview();
            leaveReviewInterface.addReview(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter, dataaccess, leaveReviewWelcomeMenuInterface);
        } catch (logInUseCase.InvalidInputException e) {
            throw new RuntimeException(e);
        }


    }
    public void addReviewComment(Scanner scanner, Scanner scanner2, String course, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface dataaccess,
                                 LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface) throws IOException, ClassNotFoundException, InvalidInputException {
        leaveReviewPresenter.outputMessage("Give this course an integer rating from 0 to 5 stars:"+ "\n");

        String rating = scanner.nextLine();
        leaveReviewPresenter.outputMessage("Enter your comment for this review:" + "\n");
        String c = scanner2.nextLine();

        try{
            leaveReviewController.addReview(course, rating, c);
            leaveReviewPresenter.outputMessage("Your review has been added!" + "\n");
            FilterOutputBoundary filterOutputBoundary = new FilterPresenter();
            FilterInputBoundary filterInputBoundary = new FilterUseCaseInteractor(dataaccess, filterOutputBoundary);
            FilterController filterController =  new FilterController(filterInputBoundary);
            ViewCourseMenu viewCourseMenu = new ViewCourseMenu();
            viewCourseMenu.displayAfterFilterOptions();
            Scanner scanner3 = new Scanner(System.in);
            viewCourseMenu.chooseOptions(scanner3, filterController);

        }catch (InvalidInputException e) {
            leaveReviewPresenter.outputMessage("Invalid Input! Please ensure your rating is between 0 and 5 inclusive!" + "\n");
            LeaveReviewInterface leaveReviewInterface = new LeaveReview();
            leaveReviewInterface.addReviewComment(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter, dataaccess, leaveReviewWelcomeMenuInterface);

        }catch (InputMismatchException f) {
            leaveReviewPresenter.outputMessage("Invalid Input! Please ensure that your rating is an integer!" + "\n");
            LeaveReviewInterface leaveReviewInterface = new LeaveReview();
            leaveReviewInterface.addReviewComment(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter, dataaccess, leaveReviewWelcomeMenuInterface);

        }catch (InvalidCommentLengthException g) {
            leaveReviewPresenter.outputMessage("Invalid Input! Please ensure your comment has more than 0 but less than 280 " +
                    "characters!"+ "\n");
            LeaveReviewInterface leaveReviewInterface = new LeaveReview();
            leaveReviewInterface.addReviewComment(scanner, scanner2, course, leaveReviewController, leaveReviewPresenter, dataaccess, leaveReviewWelcomeMenuInterface);
        } catch (logInUseCase.InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }
}
