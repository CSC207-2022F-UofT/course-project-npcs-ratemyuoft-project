package useCases.likeReviewUseCase;

public class LikeMessageResponseModel {
    /**
     * LikeMessageResponseModel: Output Data for Like Review Use Case
     * LikeMessageResponseModel: Takes in String, stores it in Local Variable
     * LikeOutput: returns the Name of Review that has been liked.
     */
    public String r;

    public LikeMessageResponseModel(String r){
        this.r = r;
    }

    public String LikeOutput(){
        return "Liked: " + r;
    }
}
