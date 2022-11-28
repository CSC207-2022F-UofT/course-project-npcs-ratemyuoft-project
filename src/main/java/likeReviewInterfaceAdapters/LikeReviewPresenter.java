package likeReviewInterfaceAdapters;

import likeReviewUsecase.LikeReviewOutputBoundary;

public class LikeReviewPresenter implements LikeReviewOutputBoundary {
    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }
}
