package likeReviewInterfaceAdapters;

import entity.Review;
import likeReviewUseCase.InputBoundaryL;
import likeReviewUseCase.ReviewNameRequestModel;

import java.io.IOException;

public class ControllerL {
    // Like Review Controller, Takes in an Input Boundary
    final InputBoundaryL ip;

    public ControllerL(InputBoundaryL ip){
        this.ip = ip;

    }

    public void Like(String reviewname) throws IOException, ClassNotFoundException {
        // Takes in a review name String from the UI and gives it to the Interactor
        ReviewNameRequestModel revname = new ReviewNameRequestModel(reviewname);
        this.ip.AddLike(revname);
    }
}
