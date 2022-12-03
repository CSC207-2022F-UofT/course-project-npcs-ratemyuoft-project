package likeReviewInterfaceAdapters;

import likeReviewUseCase.LikeMessageRequestModel;
import likeReviewUseCase.OutputBoundaryL;

public class PresenterL implements OutputBoundaryL {
    // Takes in  LikeMessageRequestModel and outputs it to the UI
    @Override
    public void outputMessage(LikeMessageRequestModel s){
        System.out.println(s.LikeOutput());
    }
}
