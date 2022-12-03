package likeReviewUseCase;

import java.io.IOException;

public interface InputBoundaryL {
    // Interface for LikeReview
    void AddLike(ReviewNameRequestModel revname) throws IOException, ClassNotFoundException;
}
