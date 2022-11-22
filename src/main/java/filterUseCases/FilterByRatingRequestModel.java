package filterUseCases;

public class FilterByRatingRequestModel {

    final private int rating;

    public FilterByRatingRequestModel(int rating){ this.rating = rating; }

    public int getRating(){ return this.rating; }

}
