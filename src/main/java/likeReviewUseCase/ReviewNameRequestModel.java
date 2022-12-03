package likeReviewUseCase;

public class ReviewNameRequestModel {
    // Review Name Input Data
    String reviewname;

    public ReviewNameRequestModel(String reviewname){
        this.reviewname = reviewname;
    }

    public String getReviewName(){
        return this.reviewname;

    }


}
