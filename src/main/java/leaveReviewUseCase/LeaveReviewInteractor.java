//package leaveReviewUseCase;
//
//import entities.Course;
//import entities.CourseList;
//import entities.Review;
//
//import java.io.IOException;
//
///**
// * The interactor is the onlu class that can interact with entities.
// * It does al the work and passes it to the Output Boundary
// */
//
//public class LeaveReviewInteractor implements LeaveReviewInputBoundary {
//    public LeaveReviewOutputBoundary outputBoundary;
//    public CourseList courseList;
//    public CourseDataAccessInterface database;
//    public Course course;
//
//    /**
//     *
//     * @param outputBoundary is needed to pass the results of performing some method
//     * @param dataAccess is needed in order to access the database
//     */
//
//    public LeaveReviewInteractor(LeaveReviewOutputBoundary outputBoundary, CourseDataAccessInterface dataAccess) {
//        this.outputBoundary = outputBoundary;
//        this.database = dataAccess;
//
//        try {
//            this.courseList = this.database.importCourseList();
//            System.out.println("Good");
//        } catch (IOException | ClassNotFoundException e) {
//            this.courseList = new CourseList();
//        }
//    }
//
//    //helper function for add Review
//    public boolean checkInput(int rating) {
//        return rating < 6 && rating >= 0;
//    }
//    public boolean checkInput(int rating, String c) {
//        boolean intcheck = rating < 6 && rating >= 0;
//        boolean commentcheck = c.length() <= 1500 && c.length() > 0;
//        return intcheck && commentcheck;
//    }
//
//    /**
//     * parameter is the review
//     * throws InvalidInputException
//     * throws IOException
//     * Check for valid input and turn in to a new review class to send to database
//     * if input is not valid throw an exception
//     */
//
//    @Override
//    public void addReview(Course c, int r) throws InvalidInputException, IOException {
//
//        if (checkInput(r)) {
//            Review review = new Review(c, r);
//            String courseName = c.getCourseName();
//            for (Course crs: courseList) {
//                if (crs.getCourseName().equals(courseName)) {
//                    this.course = crs;
//                    break;
//                }
//            }
//            if (this.course != null){
//                this.course.reviews.add(review);
//                this.database.saveCourse(this.courseList);
//
//            }else {
//                outputMessage("Invalid Input");
//                throw new InvalidInputException();
//            }
//
//        }
//    }
//    /**
//     * parameter is the review
//     * throws InvalidInputException
//     * throws IOException
//     * Check for valid input and turn in to a new review class to send to database
//     * if input is not valid throw an exception
//     */
//
//    @Override
//    public void addReview(Course c, int r, String s) throws InvalidInputException, IOException {
//        if (checkInput(r, s)) {
//            Review review = new Review(c, r, s);
//            String courseName = c.getCourseName();
//            for (Course crs: courseList) {
//                if (crs.getCourseName().equals(courseName)) {
//                    this.course = crs;
//                    break;
//                }
//            }
//            if (this.course != null){
//                this.course.reviews.add(review);
//                this.database.saveCourse(this.courseList);
//
//            }else {
//                outputMessage("Invalid Input");
//                throw new InvalidInputException();
//            }
//
//        }
//    }
//
//    /**
//     *
//     * @param s message is being passed further to outputBoundary with no modifications
//     */
//    @Override
//    public void outputMessage(String s) {
//        this.outputBoundary.outputMessage(s);
//    }
//}
//
//
//
