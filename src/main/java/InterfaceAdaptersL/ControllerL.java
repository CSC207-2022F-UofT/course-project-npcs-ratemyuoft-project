package InterfaceAdaptersL;

import LikeReviewShawn.LikeReview;
import LikeReviewShawn.OutputBoundaryL;
import LikeReviewShawn.LikeReview;
import LikeReviewShawn.OutputBoundaryL;

import java.io.IOException;

public class ControllerL {
    private String reviewname;
    private UsecaseShawn.Gateway gatewayView;
    private LikeReviewShawn.OutputBoundaryL outputBoundary;

    public ControllerL(String reviewname, UsecaseShawn.Gateway gatewayView, OutputBoundaryL outputBoundary){

        this.reviewname = reviewname;
        this.gatewayView = gatewayView;
        this.outputBoundary = outputBoundary;
    }

    public void Like() throws IOException, ClassNotFoundException {
        LikeReview lr = new LikeReview(this.reviewname, this.gatewayView, this.outputBoundary);
        lr.AddLike();
    }
}
