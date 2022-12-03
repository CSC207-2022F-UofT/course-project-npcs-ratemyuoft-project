package likeReviewUseCase;

public class ReviewNameRequestModel {
    String reviewname;

    public ReviewNameRequestModel(String reviewname){
        this.reviewname = reviewname;
    }

    public String getReviewName(){
        return this.reviewname;

    }


}
