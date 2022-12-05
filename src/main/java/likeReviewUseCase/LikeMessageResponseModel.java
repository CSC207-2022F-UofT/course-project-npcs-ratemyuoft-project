package likeReviewUseCase;

public class LikeMessageResponseModel {
    // Takes in a String and gives an output message
    public String r;

    public LikeMessageResponseModel(String r){
        this.r = r;
    }

    public String LikeOutput(){
        return "Liked; " + r;
    }
}
