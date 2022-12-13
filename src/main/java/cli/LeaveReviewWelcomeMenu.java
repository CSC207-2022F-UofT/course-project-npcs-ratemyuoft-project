package cli;

import entities.CourseList;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewExceptions.InvalidInputException;
import courseDataBase.CourseDataAccessInterface;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LeaveReviewWelcomeMenu implements LeaveReviewWelcomeMenuInterface {

    public void displayCoursesToReview(LeaveReviewPresenter leaveReviewPresenter, CourseDataAccessInterface courseDataAccessInterface) throws NullPointerException, IOException {
        try {
            CourseList courseList = courseDataAccessInterface.importCourses();
            List<String> courseNames = courseList.getCourseNameList();
            if (courseNames.size() == 0) {
                leaveReviewPresenter.outputMessage("There are no courses to review at this time" + "\n");
            }else {
        leaveReviewPresenter.outputMessage("\n" + "Available Courses:" + "\n");
        for (String c: courseNames) {
            System.out.println(c); }
        leaveReviewPresenter.outputMessage("Please enter the name of the course you want to review" + "\n");}}
        catch (NullPointerException e) {
            leaveReviewPresenter.outputMessage("Null pointer exception raised when displaying courses to review!" + "\n");} catch (
                ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void chooseCourseToReview(Scanner scanner, Scanner scanner2, LeaveReviewController leaveReviewController, LeaveReviewPresenter leaveReviewPresenter,
                                     LeaveReviewInterface leaveReviewInterface,
                                     CourseDataAccessInterface courseDataAccessInterface)
            throws IOException, ClassNotFoundException, InvalidInputException {

        String choice = scanner.nextLine();
        CourseList courseList = courseDataAccessInterface.importCourses();
        List<String> courseNames = courseList.getCourseNameList();
        if(courseNames.contains(choice)){
            LeaveReviewChooseToCommentInterface leaveReviewChooseToCommentInterface = new LeaveReviewChooseToComment();
            leaveReviewChooseToCommentInterface.displayChooseComment(leaveReviewPresenter);
            leaveReviewChooseToCommentInterface.addReviewChooser(scanner, scanner2, choice, leaveReviewController, leaveReviewPresenter,
                    courseDataAccessInterface, this);

        } else{
            leaveReviewPresenter.outputMessage("Invalid Input! Please choose a course in the list!" + "\n");
            this.displayCoursesToReview(leaveReviewPresenter, courseDataAccessInterface);
            this.chooseCourseToReview(scanner, scanner2, leaveReviewController, leaveReviewPresenter, leaveReviewInterface,
                    courseDataAccessInterface);
        }
    }
}
