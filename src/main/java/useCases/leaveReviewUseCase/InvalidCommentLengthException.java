package useCases.leaveReviewUseCase;

/**
 * This exception is raised if the OptionalComment of a review is has a length of 0 or a length greater than 280
 * characters.
 */
public class InvalidCommentLengthException extends Exception{
}
