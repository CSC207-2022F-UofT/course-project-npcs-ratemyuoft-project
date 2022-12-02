package filterUseCases;

public interface FilterInputBoundary {

    void filterByName(FilterByNameRequestModel filterByNameRequestModel);

    void filterByFOS(FilterByFOSRequestModel filterByFOSRequestModel);

    void filterByRating(FilterByRatingRequestModel filterByRatingRequestModel);
}
