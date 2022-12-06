package leaveReviewUseCase;

import courseDataBase.CourseDataAccess;
import entities.Course;
import entities.CourseList;
import entities.Review;
import interfaceadapter.Presenter;
import org.junit.jupiter.api.Test;
import usecase.*;

import java.io.IOException;
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

    private final Course course1 = new Course("STA400", "Statistical Sciences");

    private final Interactor interactor = new Interactor(outputBoundary, database);

    /**
     * This test tests if the course is correctly added to the database
     * @throws InvalidInputException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testAddReview1() throws InvalidInputException, IOException, ClassNotFoundException {
        CourseList cl = new CourseList();
        CourseList c2 = new CourseList();
        cl.addCourse(course1);
        database.saveCourse(cl);
        assertEquals("STA400", database.importCourses().getCourseNameList().get(0));
    }

    /**
     * This method tests if the LeaveReview Interactor correctly updates the database if the review does not have comment.
     * It also tests if the reviewID of the review is correctly updated if the review is the first review of the course.
     * @throws InvalidInputException Exceptions are thrown for debugging purposes
     * @throws IOException Exceptions are thrown for debugging purposes
     * @throws ClassNotFoundException Exceptions are thrown for debugging purposes
     *
     */

    @Test
    public void testInteractor1() throws InvalidInputException, IOException, ClassNotFoundException {
        interactor.addReview("STA400", 4);
        assertEquals("STA400Review0", database.importCourses().getCourseWithName("STA400").getReviews().get(0).getReviewID());
        interactor.addReview("STA400", 4, "this course sucks");
        assertEquals("STA400Review1", database.importCourses().getCourseWithName("STA400").getReviews().get(1).getReviewID());

    }

    /**
     * This method tests if the LeaveReview Interactor correctly updates the database if the review has a comment.
     * It also test that the reviewID of the review is correctly updated if the review is not the first review of the
     * course.
     * @throws InvalidInputException Exceptions are thrown for debugging purposes
     * @throws IOException Exceptions are thrown for debugging purposes
     * @throws ClassNotFoundException Exceptions are thrown for debugging purposes
     *
     */

//    @Test
//    public void testInteractorComment2() throws InvalidInputException, IOException, ClassNotFoundException {
//        interactor.addReview("STA400", 4, "this course sucks");
//        assertEquals("STA400Review1", database.importCourses().getCourseWithName("STA400").getReviews().get(1).getReviewID());
//
//    }


}