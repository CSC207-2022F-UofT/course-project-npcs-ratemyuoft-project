package likeReviewUseCase;

import java.io.IOException;

public interface LikeReviewInputBoundary {
    // Interface for LikeReview
    void AddLike(ReviewNameRequestModel revname) throws IOException, ClassNotFoundException;
}
