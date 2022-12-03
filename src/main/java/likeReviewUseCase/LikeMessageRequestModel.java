package likeReviewUseCase;

import entity.Review;

public class LikeMessageRequestModel {
    public String r;

    public LikeMessageRequestModel(String r){
        this.r = r;
    }

    public String LikeOutput(){
        return "Liked; " + r;
    }
}
