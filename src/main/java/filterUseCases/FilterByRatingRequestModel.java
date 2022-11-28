package filterUseCases;

public class FilterByRatingRequestModel {

    final private double rating;

    public FilterByRatingRequestModel(double rating){ this.rating = rating; }

    public double getRating(){ return this.rating; }

}
