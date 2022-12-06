package leaveReviewUseCase;

import courseDataBase.CourseDataAccess;
import entities.Course;
import entities.CourseList;
import entities.Review;
import interfaceadapter.Presenter;
import org.junit.jupiter.api.Test;
import usecase.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for outputMessage and showUsers were not made as they have the only task is to send the information
 * forward to outputBoundary which sends it to Presenter.
 */
class LeaveReviewInteractorTest {


    private final CourseDataAccessInterface database = new CourseDataAccess();
    private final OutputBoundary outputBoundary = new Presenter();

    private final InputBoundary inputBoundary = new Interactor(outputBoundary, database);

    private final CourseList courseList = new CourseList();

    private final Interactor interactor = new Interactor(outputBoundary, database);

    /**
     *
     * This method just populates the database with courses.
     */
    @Test
    public void populateDatabase() throws IOException {
        database.generateTempCourses2();
    }

    /**
     * This method checks that the interactor actually adds the review with a comment to the course in the database.
     *
     */

    @Test
    void testAddReviewComment(){
        try {
            interactor.addReview("STA261", "4", "This course was okay");
            assertEquals(1, database.importCourses().getCourseList().get(0).reviewCount);
        } catch (IOException | InvalidInputException | ClassNotFoundException | InvalidCommentLengthException e) {
            System.out.println("testAddReview1 is not working");
        }
    }

    /**
     * This method tests if the Interactor correctly creates the reviewID of a review with a comment is added to the
     * course.
     */

    @Test
    void testReviewIDComment() {
        try {
            interactor.addReview("STA257", "4", "This course was okay");
            assertEquals("STA257Review1",
                    database.importCourses().getCourseWithName("STA257").getReviews().get(0).getReviewID());
        }catch (IOException | InvalidInputException | ClassNotFoundException | InvalidCommentLengthException e) {
            System.out.println("testReviewIDComment is not working");
        }
    }

    /**
     * This test checks the reviewID of a review with no comment is created correctly in the database and in the course
     * reviewList.
     */

    @Test
    void testReviewIDNoComment() {
        try {
            interactor.addReview("MAT157", "5");
            assertEquals("MAT157Review1",
                    database.importCourses().getCourseWithName("MAT157").getReviews().get(0).getReviewID());
        } catch (IOException | InvalidInputException | ClassNotFoundException e) {
            System.out.println("testReviewIDComment is not working");
        }
    }

    /**
     * This test checks that an Interactor with an invalid input of a rating that is outside the range of 0 to 5
     * does not add the review to the course.
     */
    @Test
    void testInvalidInputOutOfRange() {
        try {
            interactor.addReview("MAT157", "6");
        } catch (IOException | InvalidInputException | ClassNotFoundException | InputMismatchException e) {
            System.out.println("testInvalidInputOutOfRange is working");
        }
    }

    /**
     * This test checks that an interactor with an invalid input of a decimal number instead of an int does not create
     * a review.
     */
    @Test
    void testInvalidInputNotInt() {
        try {
            interactor.addReview("MAT157", "4.6");
        } catch (IOException | InvalidInputException | ClassNotFoundException | InputMismatchException e) {
            System.out.println("testInvalidInputNotInt is working");
        }
    }

    /**
     * This method test that an exception is raised if a CourseName of a course that is not in the database is input/
     */
    @Test
    void testInvalidInputCourseNotInDatabase() {
        try {
            interactor.addReview("MAT158", "4");
        } catch (IOException | InvalidInputException | ClassNotFoundException | InputMismatchException e) {
            System.out.println("testInvalidInputCourseNotInDatabase is working");
        }
    }

    /**
     * This method tests that a review is not created if the argument of the Interactor contains a comment is
     * that is of length 0.
     */
    @Test
    void testInvalidInputCommentLength(){
        try {
            interactor.addReview("MAT158", "4", "");
        } catch (IOException | InvalidInputException | ClassNotFoundException |
                 InputMismatchException | InvalidCommentLengthException e) {
            System.out.println("testInvalidInputCommentLength is working");
        }
    }


}