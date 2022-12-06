package leaveReviewUseCase;

/**
 * LeaveReviewCommentRequestModel is one of the three request models. It stores the comment information.
 * When addReview is called by controller, a leaveReviewCommentRequestModel is constructed and passed into the
 * LeaveReviewInputBoundary as a parameter of addReview method. This eliminated the dependency on the user input and
 * makes the use case clean and SOLID.
 */

public class LeaveReviewCommentRequestModel {

    final private String comment;

    public LeaveReviewCommentRequestModel(String comment) {this.comment = comment;
    }

    public String getComment() {return this.comment;}
}
