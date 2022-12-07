package likeReviewInterfaceAdapters;

import likeReviewUseCase.LikeReviewInputBoundary;
import likeReviewUseCase.ReviewNameRequestModel;

import java.io.IOException;

public class LikeReviewController {
    /**
     * LikeReviewController: Controller for LikeReview Use Case
     * LikeReviewController: Takes in Input Boudnary and Stores it in Local
     * Like: Takes in a String, creates a ReviewNameRequestModel Input Data Type and gives it to the inputBoundary
     * AddLike Method
     */
    final LikeReviewInputBoundary ip;

    public LikeReviewController(LikeReviewInputBoundary ip){
        this.ip = ip;

    }

    public void Like(String reviewname) throws IOException, ClassNotFoundException {
        ReviewNameRequestModel revname = new ReviewNameRequestModel(reviewname);
        this.ip.AddLike(revname);
    }
}
