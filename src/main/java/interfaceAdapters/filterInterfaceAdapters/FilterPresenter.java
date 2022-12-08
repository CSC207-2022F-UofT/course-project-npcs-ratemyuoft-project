package interfaceAdapters.filterInterfaceAdapters;

import useCases.filterUseCases.FilterOutputBoundary;
import dataStructures.filterDataStructures.FilterResponseModel;

/**
 * FilterPresenter class implements the FilterOutputBoundary interface and specifies its methods. It is the Presenter for the Filter/look for
 * courses use case.
 */
public class FilterPresenter implements FilterOutputBoundary {

    /**
     * filterView is the view for successfully filtering a course, this method prints out the FilterResponseModel which
     * is a form of output data tailor the to command line interface, which we are using for the UI.
     * @param filterResponseModel is the response model that was created inside the input boundaries of filter use case.
     */
    @Override
    public void filterView(FilterResponseModel filterResponseModel){
        System.out.println(filterResponseModel);
    }

    /**
     * filterFailView is the view for failure of filtering a course, it basically throws the relevant FilterFailException
     * @param error the message explaining the exception.
     */
    @Override
    public void filterFailView(String error) {
        throw new FilterFailException(error);
    }
}
