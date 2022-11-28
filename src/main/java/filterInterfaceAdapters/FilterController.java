package filterInterfaceAdapters;

import filterUseCases.*;

public class FilterController {

    final FilterInputBoundary interactor;


    public FilterController(FilterInputBoundary interactor) {
        this.interactor = interactor;
    }

    public FilterResponseModel filterByName(String name) {
         return interactor.filterByName(new FilterByNameRequestModel(name));
    }

    public FilterResponseModel filterByFOS(String FOS) {
        FilterByFOSRequestModel filterByFOSRequestModel = new FilterByFOSRequestModel(FOS);
        return interactor.filterByFOS(filterByFOSRequestModel);
    }

    public FilterResponseModel filterByRating(double rating) {
        FilterByRatingRequestModel filterByRatingRequestModel = new FilterByRatingRequestModel(rating);
        return interactor.filterByRating(filterByRatingRequestModel);
    }

}
