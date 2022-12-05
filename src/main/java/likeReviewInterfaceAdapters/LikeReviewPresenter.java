package likeReviewInterfaceAdapters;

import likeReviewUseCase.LikeMessageResponseModel;
import likeReviewUseCase.LikeReviewOutputBoundary;

public class LikeReviewPresenter implements LikeReviewOutputBoundary {
    // Takes in  LikeMessageRequestModel and outputs it to the UI
    @Override
    public void outputMessage(LikeMessageResponseModel s){
        System.out.println(s.LikeOutput());
    }
}
