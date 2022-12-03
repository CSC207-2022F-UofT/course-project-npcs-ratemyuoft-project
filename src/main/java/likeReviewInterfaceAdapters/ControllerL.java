package likeReviewInterfaceAdapters;

import entity.Review;
import likeReviewUseCase.InputBoundaryL;

import java.io.IOException;

public class ControllerL {
    final InputBoundaryL ip;

    public ControllerL(InputBoundaryL ip){
        this.ip = ip;

    }

    public void Like(String reviewname) throws IOException, ClassNotFoundException {
        this.ip.AddLike(reviewname);
    }
}
