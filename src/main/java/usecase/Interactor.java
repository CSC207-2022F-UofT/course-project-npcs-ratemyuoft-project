package usecase;

import entities.Course;
import entities.CourseList;
import entities.Review;

import java.io.IOException;

/**
 * The interactor is the onlu class that can interact with entities.
 * It does al the work and passes it to the Output Boundary
 */

public class Interactor implements InputBoundary {
    public OutputBoundary outputBoundary;
    public CourseList courseList;
    public CourseDataAccessInterface database;

    public Course course;

    /**
     *
     * @param outputBoundary is needed to pass the results of performing some method
     * @param dataAccess is needed in order to access the database
     */

    public Interactor(OutputBoundary outputBoundary, CourseDataAccessInterface dataAccess) {
        this.outputBoundary = outputBoundary;
        this.database = dataAccess;

        try {
            this.courseList = this.database.importCourses();
            System.out.println("Interactor has been successfully constructed!");
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }
    }

    //helper function for add Review
    public boolean checkInput(int rating) {
        return rating <= 5 && rating >= 0;
    }
    public boolean checkInput(int rating, String c) {
        boolean intCheck = rating <= 5 && rating >= 0;
        boolean commentCheck = c.length() <= 1500 && c.length() > 0;
        return intCheck && commentCheck;
    }

    /**
     * parameter is the name of the course we want to add the review to and the rating of the review
     * throws InvalidInputException
     * throws IOException
     * Check for valid input and turn in to a new review class to send to database
     * if input is not valid throw an exception
     */

    @Override
    public void addReview(String courseName, int r) throws InvalidInputException, IOException, ClassNotFoundException {

        if (checkInput(r)) {
            if (courseList.containsCourseWithName(courseName)) {
                course = courseList.getCourseWithName(courseName);
                Review newReview = new Review(course, r);
                newReview.setReviewID(course.getReviewCount());
                course.addReview(newReview);
                database.saveCourse(courseList);
            }else throw new InvalidInputException();
        } else throw new InvalidInputException();
    }

    @Override
    public void addReview(String courseName, int r, String c) throws InvalidInputException, IOException, ClassNotFoundException {
        if (checkInput(r, c)) {
            if (courseList.containsCourseWithName(courseName)) {
                course = courseList.getCourseWithName(courseName);
                Review newReview = new Review(course, r, c);
                newReview.setReviewID(course.getReviewCount());
                course.addReview(newReview);
                database.saveCourse(courseList);
            }else throw new InvalidInputException();
        } else throw new InvalidInputException();
    }
    /**
     *
     * @param s message is being passed further to outputBoundary with no modifications
     */
    @Override
    public void outputMessage(String s) {
        this.outputBoundary.outputMessage(s);
    }
}



