package filterUseCases;

import dataStructures.FilterResponseModel;

/**
 * FilterOutputBoundary is an interface outlining the methods specified in the filter presenter. It is stored in the interactor
 * and called to use when needed.
 */

public interface FilterOutputBoundary {

    void filterView(FilterResponseModel filterResponseModel);

    void filterFailView (String s);
}
