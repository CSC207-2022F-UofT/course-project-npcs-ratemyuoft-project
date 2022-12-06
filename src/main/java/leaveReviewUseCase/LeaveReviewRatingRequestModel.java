package leaveReviewUseCase;

/**
 * LeaveReviewRatingRequestModel. It stores the rating information.
 * When addReview is called by controller, a leaveReviewRatingRequestModel is constructed and passed into the
 * LeaveReviewInputBoundary as a parameter of addReview method. This eliminated the dependency on the user input and
 * makes the use case clean and SOLID.
 */

public class LeaveReviewRatingRequestModel {
    final private String rating;
    public LeaveReviewRatingRequestModel(String rating) { this.rating = rating;}

    public String getRating() { return this.rating;}
}
