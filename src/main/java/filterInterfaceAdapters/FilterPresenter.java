package filterInterfaceAdapters;

import filterUseCases.FilterOutputBoundary;
import dataStructures.FilterResponseModel;

public class FilterPresenter implements FilterOutputBoundary {

    @Override
    public void filterView(FilterResponseModel filterResponseModel){
        System.out.println(filterResponseModel);
    }

    @Override
    public void filterFailView(String error) {
        throw new FilterFailException(error);
    }
}
