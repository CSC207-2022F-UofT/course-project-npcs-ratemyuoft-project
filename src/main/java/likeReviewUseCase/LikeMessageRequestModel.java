package likeReviewUseCase;

import entity.Review;

public class LikeMessageRequestModel {
    // Takes in a String and gives an output message
    public String r;

    public LikeMessageRequestModel(String r){
        this.r = r;
    }

    public String LikeOutput(){
        return "Liked; " + r;
    }
}
