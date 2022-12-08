package interfaceAdapters.likeReviewInterfaceAdapters;

import useCases.likeReviewUseCase.LikeMessageResponseModel;
import useCases.likeReviewUseCase.LikeReviewOutputBoundary;

public class LikeReviewPresenter implements LikeReviewOutputBoundary {
    /**
     * LikeReviewPresenter: Presenter for LikeReview Use Case
     * outputMessage: Takes in a LikeMessage Response Model and outputs its LikeOutput Method onto main.
     */
    @Override
    public void outputMessage(LikeMessageResponseModel s){
        System.out.println(s.LikeOutput());
    }
}
