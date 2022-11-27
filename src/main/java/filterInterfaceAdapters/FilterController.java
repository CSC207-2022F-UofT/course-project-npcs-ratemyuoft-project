package filterInterfaceAdapters;

import filterUseCases.*;

public class FilterController {

    final FilterInputBoundary interactor;


    public FilterController(FilterInputBoundary interactor) {
        this.interactor = interactor;
    }

    public FilterResponseModel FilterByName(String name) {
         FilterByNameRequestModel filterByNameRequestModel = new FilterByNameRequestModel(name);
         return interactor.filterByName(filterByNameRequestModel);
    }

    public FilterResponseModel FilterByFOS(String FOS) {
        FilterByFOSRequestModel filterByFOSRequestModel = new FilterByFOSRequestModel(FOS);
        return interactor.filterByFOS(filterByFOSRequestModel);
    }

    public FilterResponseModel FilterByRating(int rating) {
        FilterByRatingRequestModel filterByRatingRequestModel = new FilterByRatingRequestModel(rating);
        return interactor.filterByRating(filterByRatingRequestModel);
    }


}
