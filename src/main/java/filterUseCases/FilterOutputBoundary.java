package filterUseCases;

import dataStructures.FilterResponseModel;

public interface FilterOutputBoundary {

    void filterView(FilterResponseModel filterResponseModel);

    void filterFailView (String s);
}
