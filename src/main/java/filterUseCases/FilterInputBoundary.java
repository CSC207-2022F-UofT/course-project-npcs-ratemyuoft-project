package filterUseCases;

public interface FilterInputBoundary {

    FilterResponseModel filterByName(FilterByNameRequestModel filterByNameRequestModel);

    FilterResponseModel filterByFOS(FilterByFOSRequestModel filterByFOSRequestModel);

    FilterResponseModel filterByRating(FilterByRatingRequestModel filterByRatingRequestModel);
}
