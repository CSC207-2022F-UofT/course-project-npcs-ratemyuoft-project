package leaveReviewUseCase;

/**
 * LeaveReviewCourseRequestModel is one of the three request models. It stores the courseName information.
 * When addReview is called by controller, a leaveReviewCourseRequestModel is constructed and passed into the
 * LeaveReviewInputBoundary as a parameter of addReview method. This eliminated the dependency on the user input and
 * makes the use case clean and SOLID.
 */

public class LeaveReviewCourseRequestModel {
    final private String courseName;

    public LeaveReviewCourseRequestModel(String courseName) {this.courseName = courseName;}

    public String getCourseName() {return this.courseName;}
}
