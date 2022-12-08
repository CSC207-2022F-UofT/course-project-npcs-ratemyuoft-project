package useCases.likeReviewUseCase;

import java.io.IOException;

public interface LikeReviewInputBoundary {
    /**
     * LikeReviewInputBoundary: Input Boundary for Like Review Use Case
     * AddLike: Takes in a ReviewNameRequestModel.
     */
    void AddLike(ReviewNameRequestModel revname) throws IOException, ClassNotFoundException;
}
