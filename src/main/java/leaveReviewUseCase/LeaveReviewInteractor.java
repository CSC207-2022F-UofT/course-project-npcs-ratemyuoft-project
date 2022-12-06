package leaveReviewUseCase;

import entities.Course;
import entities.CourseList;
import entities.Review;

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

    /**
     *
     * @param leaveReviewOutputBoundary is needed to pass the results of performing some method
     * @param dataAccess is needed in order to access the database
     */

    public LeaveReviewInteractor(LeaveReviewOutputBoundary leaveReviewOutputBoundary, CourseDataAccessInterface dataAccess) {
        this.leaveReviewOutputBoundary = leaveReviewOutputBoundary;
        this.database = dataAccess;

        try {
            this.courseList = this.database.importCourses();
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }
    }

    /**
     * The isInteger function is a helper function that checks if the string input is an integer if it
     * were to be converted to an integer. This was implemented inorder ot stop the program from crashing if a non
     * integer value is input in an int scanner.
     */
    public boolean isInteger(LeaveReviewRatingRequestModel r) {
        return isInteger(r.getRating(), 10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    /**
     * The checkInput function is a helpfer function of the LeaveReviewInteractor that checks if the rating is within the bounds
     * of 0 and 5 and also checks if the rating is an integer.
     * This function also checks if the comment of the review is within the character limit of 280 characters and has
     * at least 1 character.
     */
    public boolean checkInputRating(LeaveReviewRatingRequestModel r) {
            return Integer.parseInt(r.getRating()) <= 5 && Integer.parseInt(r.getRating()) > 0;
    }
    public boolean checkInputComment(LeaveReviewCommentRequestModel c) {
        return c.getComment().length() <= 280 && c.getComment().length() > 0;
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
                          LeaveReviewRatingRequestModel ratingRequestModel) throws InvalidInputException,
            InputMismatchException, ClassNotFoundException, IOException {

        if (isInteger(ratingRequestModel)) {
            if (checkInputRating(ratingRequestModel)) {
                if (courseList.containsCourseWithName(courseRequestModel.getCourseName())) {
                    course = courseList.getCourseWithName(courseRequestModel.getCourseName());
                    Review newReview = new Review(course, Integer.parseInt(ratingRequestModel.getRating()));
                    course.addReview(newReview);
                    database.saveCourse(courseList);
                } else throw new InvalidInputException();
            } else throw new InvalidInputException();
        } else throw new InputMismatchException();
    }

    /**
     * This method adds a review with a comment to the course that is being reviewed and updated the database after
     * doing so.
     * @param courseRequestModel The request model of the name of the course being reviewed
     * @param ratingRequestModel The request model of the rating the user is giving the course
     * @param commentRequestModel The request model of the comment the user is adding to their review.
     * @throws InvalidInputException This is thrown when rating is not between 0 and 5 or when the courseName is not in
     * the database
     * @throws InputMismatchException This is thrown when the input of the review can not be converted to an int
     * @throws InvalidCommentLengthException This is thrown if the comment of the review is either of length 0 or is
     * above the limit of 280 characters.
     */

    @Override
    public void addReview(LeaveReviewCourseRequestModel courseRequestModel,
                          LeaveReviewRatingRequestModel ratingRequestModel,
                          LeaveReviewCommentRequestModel commentRequestModel) throws InvalidInputException, IOException,
            ClassNotFoundException, InvalidCommentLengthException {
        if (isInteger(ratingRequestModel)) {
            if (checkInputRating(ratingRequestModel)) {
                if (checkInputComment(commentRequestModel)) {
                    if (courseList.containsCourseWithName(courseRequestModel.getCourseName())) {
                        course = courseList.getCourseWithName(courseRequestModel.getCourseName());
                        Review newReview = new Review(course, Integer.parseInt(ratingRequestModel.getRating()),
                                commentRequestModel.getComment());
                        course.addReview(newReview);
                        database.saveCourse(courseList);
                    } else throw new InvalidInputException();
                } else throw new InvalidCommentLengthException();
            }else throw new InvalidInputException();
        }else throw new InputMismatchException();
    }
}



