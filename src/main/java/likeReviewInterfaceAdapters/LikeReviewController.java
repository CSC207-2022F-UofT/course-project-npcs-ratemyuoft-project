package likeReviewInterfaceAdapters;

import likeReviewUseCase.LikeReviewInputBoundary;
import likeReviewUseCase.ReviewNameRequestModel;

import java.io.IOException;

public class LikeReviewController {
    // Like Review Controller, Takes in an Input Boundary
    final LikeReviewInputBoundary ip;

    public LikeReviewController(LikeReviewInputBoundary ip){
        this.ip = ip;

    }

    public void Like(String reviewname) throws IOException, ClassNotFoundException {
        // Takes in a review name String from the UI and gives it to the Interactor
        ReviewNameRequestModel revname = new ReviewNameRequestModel(reviewname);
        this.ip.AddLike(revname);
    }
}
