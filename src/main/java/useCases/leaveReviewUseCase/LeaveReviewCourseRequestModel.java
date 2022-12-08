package useCases.leaveReviewUseCase;

/**
 * LeaveReviewCourseRequestModel is one of the three request models. It stores the courseName information.
 * When addReview is called by controller, a leaveReviewCourseRequestModel is constructed and passed into the
 * LeaveReviewInputBoundary as a parameter of addReview method. This eliminated the dependency on the user input and
 * makes the use case clean and SOLID.
 */

public class LeaveReviewCourseRequestModel {

    /**
     * This instance variable is the name of the course that the reviewer decided to review.
     */
    final private String courseName;

    /**
     * The constructor of this request model assigns the courseName instance variable to the name in the parameter.
     */
    public LeaveReviewCourseRequestModel(String courseName) {this.courseName = courseName;}

    /**
     * This getter returns the courseName instance variable of this request model.
     */
    // Getter
    public String getCourseName() {return this.courseName;}
}
