package filterUseCases;

/**
 * filterInputBoundary is an interface outlining the methods interactors. It is called by the methods of
 * FilterController.
 */
public interface FilterInputBoundary {

    void filterByName(FilterByNameRequestModel filterByNameRequestModel);

    void filterByFOS(FilterByFOSRequestModel filterByFOSRequestModel);

    void filterByRating(FilterByRatingRequestModel filterByRatingRequestModel);
}
