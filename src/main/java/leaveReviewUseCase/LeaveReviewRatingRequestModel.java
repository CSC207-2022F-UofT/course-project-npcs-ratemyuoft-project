package leaveReviewUseCase;

/**
 * LeaveReviewRatingRequestModel. It stores the rating information.
 * When addReview is called by controller, a leaveReviewRatingRequestModel is constructed and passed into the
 * LeaveReviewInputBoundary as a parameter of addReview method. This eliminated the dependency on the user input and
 * makes the use case clean and SOLID.
 */

public class LeaveReviewRatingRequestModel {

    /**
     * This instance variable is the rating of the course that the reviewer decided to review. The rating is in a string
     * type in order to prevent crashing of the program if an invalid type of number is input.
     */
    final private String rating;

    /**
     * The constructor of this request model assigns the rating instance variable to the rating in the parameter.
     */
    public LeaveReviewRatingRequestModel(String rating) { this.rating = rating;}

    /**
     * This getter returns the rating instance variable of this request model.
     */
    // Getter
    public String getRating() { return this.rating;}
}
