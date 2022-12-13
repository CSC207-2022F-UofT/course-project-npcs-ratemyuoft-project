package leaveReviewUseCase;

import courseDataBase.CourseDataAccessInterface;
import entities.Course;
import entities.CourseList;
import entities.Review;
import leaveReviewExceptions.InvalidCommentLengthException;
import leaveReviewExceptions.InvalidInputException;
import leaveReviewExceptions.InvalidRatingException;
import leaveReviewExceptions.CourseNotInDatabaseException;


import java.io.IOException;
import java.util.InputMismatchException;

/**
 * The interactor is the onlu class that can interact with entities.
 * It does al the work and passes it to the Output Boundary
 */

public class LeaveReviewInteractor implements LeaveReviewInputBoundary {
    public LeaveReviewOutputBoundary leaveReviewOutputBoundary;
    public CourseList courseList;
    public CourseDataAccessInterface database;

    public Course course;

    public LeaveReviewVerifier leaveReviewVerifier;

    /**
     *
     * @param leaveReviewOutputBoundary is needed to pass the results of performing some method
     * @param dataAccess is needed in order to access the database
     */

    public LeaveReviewInteractor(LeaveReviewOutputBoundary leaveReviewOutputBoundary, CourseDataAccessInterface dataAccess) {
        this.leaveReviewOutputBoundary = leaveReviewOutputBoundary;
        this.database = dataAccess;
        this.leaveReviewVerifier = new LeaveReviewVerifier();

        try {
            this.courseList = this.database.importCourses();
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }
    }

    /**
     * This method adds a review with no comment to the course that is being reviewed and updated the database after
     * doing so.
     * @param courseRequestModel The request model of the name of the course being reviewed
     * @param ratingRequestModel The request model of the rating the user is giving the course
     * @throws InvalidInputException This is thrown when rating is not between 0 and 5 or when the courseName is not in
     * the database
     * @throws InputMismatchException This is thrown when the input of the review can not be converted to an int
     */

    @Override
    public void addReview(LeaveReviewCourseRequestModel courseRequestModel,
                          LeaveReviewRatingRequestModel ratingRequestModel) throws InputMismatchException,
            ClassNotFoundException, IOException, InvalidRatingException, CourseNotInDatabaseException {

        if (leaveReviewVerifier.isInteger(ratingRequestModel)) {
            if (leaveReviewVerifier.checkInputRating(ratingRequestModel)) {
                if (courseList.containsCourseWithName(courseRequestModel.getCourseName())) {
                    course = courseList.getCourseWithName(courseRequestModel.getCourseName());
                    Review newReview = new Review(course, Integer.parseInt(ratingRequestModel.getRating()));
                    course.addReview(newReview);
                    database.saveCourse(courseList);
                } else throw new CourseNotInDatabaseException();
            } else throw new InvalidRatingException();
        } else throw new InputMismatchException();
    }

    /**
     * This method adds a review with a comment to the course that is being reviewed and updated the database after
     * doing so.
     * @param courseRequestModel The request model of the name of the course being reviewed
     * @param ratingRequestModel The request model of the rating the user is giving the course
     * @param commentRequestModel The request model of the comment the user is adding to their review.
     * @throws InputMismatchException This is thrown when the input of the review can not be converted to an int
     * @throws InvalidCommentLengthException This is thrown if the comment of the review is either of length 0 or is
     * above the limit of 280 characters.
     * @throws CourseNotInDatabaseException This is thrown if the course the user has input is not in the database.
     * @throws InvalidRatingException This is thrown if the rating that has been input is invalid.
     */

    @Override
    public void addReview(LeaveReviewCourseRequestModel courseRequestModel,
                          LeaveReviewRatingRequestModel ratingRequestModel,
                          LeaveReviewCommentRequestModel commentRequestModel) throws IOException,
            ClassNotFoundException, InvalidCommentLengthException, InvalidRatingException, CourseNotInDatabaseException {
        if (leaveReviewVerifier.isInteger(ratingRequestModel)) {
            if (leaveReviewVerifier.checkInputRating(ratingRequestModel)) {
                if (leaveReviewVerifier.checkInputComment(commentRequestModel)) {
                    if (courseList.containsCourseWithName(courseRequestModel.getCourseName())) {
                        course = courseList.getCourseWithName(courseRequestModel.getCourseName());
                        Review newReview = new Review(course, Integer.parseInt(ratingRequestModel.getRating()),
                                commentRequestModel.getComment());
                        course.addReview(newReview);
                        database.saveCourse(courseList);
                    } else throw new CourseNotInDatabaseException();
                } else throw new InvalidCommentLengthException();
            }else throw new InvalidRatingException();
        }else throw new InputMismatchException();
    }
}



