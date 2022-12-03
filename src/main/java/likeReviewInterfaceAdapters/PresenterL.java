package likeReviewInterfaceAdapters;

import likeReviewUseCase.LikeMessageRequestModel;
import likeReviewUseCase.OutputBoundaryL;

public class PresenterL implements OutputBoundaryL {
    @Override
    public void outputMessage(LikeMessageRequestModel s){
        System.out.println(s.LikeOutput());
    }
}
