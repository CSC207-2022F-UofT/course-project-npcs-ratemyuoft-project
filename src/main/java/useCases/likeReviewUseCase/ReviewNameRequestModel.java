package useCases.likeReviewUseCase;

public class ReviewNameRequestModel {
    /**
     * ReviewNameRequestModel: Input Data for Like Review Use Case
     * ReviewNameRequestModel: Takes in String and stores it in Local Variable
     * getReviewName: Returns reviewname
     */
    String reviewname;

    public ReviewNameRequestModel(String reviewname){
        this.reviewname = reviewname;
    }

    public String getReviewName(){
        return this.reviewname;

    }


}
