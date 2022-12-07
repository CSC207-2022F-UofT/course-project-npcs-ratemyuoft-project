package leaveReviewUseCase;

/**
 * LeaveReviewCommentRequestModel is one of the three request models. It stores the comment information.
 * When addReview is called by controller, a leaveReviewCommentRequestModel is constructed and passed into the
 * LeaveReviewInputBoundary as a parameter of addReview method. This eliminated the dependency on the user input and
 * makes the use case clean and SOLID.
 */
public class LeaveReviewCommentRequestModel {

    /**
     * This instance variable is the comment that the reviewer decided to add to the review.
     */
    final private String comment;

    /**
     * The constructor of this request model assigns the comment instance variable to the string in the parameter.
     */
    public LeaveReviewCommentRequestModel(String comment) {this.comment = comment;
    }

    /**
     * This getter returns the comment instance variable of this request model.
     */
    // Getter
    public String getComment() {return this.comment;}
}
