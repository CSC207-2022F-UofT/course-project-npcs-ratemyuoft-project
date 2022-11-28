package InterfaceAdaptersL;

import LikeReview.LikeReview;
import Usecase.Gateway;
import Usecase.OutputBoundary;
import LikeReview.OutputBoundaryL;

import java.io.IOException;

public class ControllerL {
    private String reviewname;

    private Gateway gateway;

    private OutputBoundaryL outputBoundary;

    public ControllerL(String reviewname, Gateway gateway, OutputBoundaryL outputBoundary){

        this.reviewname = reviewname;
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    public void Like() throws IOException {
        LikeReview lr = new LikeReview(this.reviewname, this.gateway, this.outputBoundary);
        //lr.AddLike();
    }
}
