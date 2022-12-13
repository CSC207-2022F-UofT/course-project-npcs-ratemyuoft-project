package leaveReviewUseCase;

/**
 * This class verifies that all inputs to do with LeaveReview are valid.
 */
public class LeaveReviewVerifier {


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
     * The checkInput function is a helper function of the LeaveReviewInteractor that checks if the rating is within the bounds
     * of 0 and 5 and also checks if the rating is an integer.
     * This function also checks if the comment of the review is within the character limit of 280 characters and has
     * at least 1 character.
     */
    public boolean checkInputRating(LeaveReviewRatingRequestModel r) {
        return Integer.parseInt(r.getRating()) <= 5 && Integer.parseInt(r.getRating()) >= 0;
    }
    public boolean checkInputComment(LeaveReviewCommentRequestModel c) {
        return c.getComment().length() <= 280 && c.getComment().length() > 0;
    }
}
