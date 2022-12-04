package filterUseCases;

/**
 * FilterByRatingRequestModel is one of the three request models. It stores the rating information.
 *
 * <p>
 *
 * When filterByRating is called by a filter controller, a FilterByRatingRequestModel is constructed and passed into the
 * FilterInputBoundary as a parameter of filterByRating method. This eliminates the dependency on the user input and makes
 * the use case clean and SOLID.
 */
public class FilterByRatingRequestModel {

    final private double rating;

    public FilterByRatingRequestModel(double rating){ this.rating = rating; }

    public double getRating(){ return this.rating; }

}
