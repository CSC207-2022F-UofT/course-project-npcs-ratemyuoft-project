package cli;

import entities.Course;
import entities.CourseList;
import interfaceadapter.Controller;
import interfaceadapter.Presenter;
import usecase.InvalidInputException;
import usecase.CourseDataAccessInterface;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WelcomeMenu implements WelcomeMenuInterface{

    public void displayCoursesToReview(Presenter presenter, CourseDataAccessInterface courseDataAccessInterface) throws NullPointerException, IOException {
        try {
            CourseList courseList = courseDataAccessInterface.importCourses();
            List<String> courseNames = courseList.getCourseNameList();
            if (courseNames.size() == 0) {
                presenter.outputMessage("There are no courses to review at this time" + "\n");
            }else {
        presenter.outputMessage("\n" + "Available Courses:" + "\n");
        for (String c: courseNames) {
            System.out.println(c); }
        presenter.outputMessage("Please enter the name of the course you want to review" + "\n");}}
        catch (NullPointerException e) {presenter.outputMessage("Null pointer exception raised when displaying courses to review!" + "\n");} catch (
                ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void chooseCourseToReview(Scanner scanner, Scanner scanner2, Controller controller, Presenter presenter,
                                     AddReviewInterface addReviewInterface,
                                     CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException, InvalidInputException {

        String choice = scanner.nextLine();
        CourseList courseList = courseDataAccessInterface.importCourses();
        List<String> courseNames = courseList.getCourseNameList();
        if(courseNames.contains(choice)){
            ChooseToCommentInterface chooseToCommentInterface = new ChooseToComment();
            chooseToCommentInterface.displayChooseComment(presenter);
            chooseToCommentInterface.addReviewChooser(scanner, scanner2, choice, controller, presenter,
                    courseDataAccessInterface, this);

        } else{
            presenter.outputMessage("Invalid Input, please choose a course in the list!" + "\n");
            this.displayCoursesToReview(presenter, courseDataAccessInterface);
            this.chooseCourseToReview(scanner, scanner2, controller, presenter, addReviewInterface,
                    courseDataAccessInterface);
        }
    }
}
