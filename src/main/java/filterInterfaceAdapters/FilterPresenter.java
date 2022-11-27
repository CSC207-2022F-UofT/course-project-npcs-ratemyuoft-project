package filterInterfaceAdapters;

import entities.CourseList;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterResponseModel;

public class FilterPresenter implements FilterOutputBoundary {

    @Override
    public FilterResponseModel filterSuccessView(CourseList courseList) {
        return new FilterResponseModel(courseList);
    }

    @Override
    public FilterResponseModel filterFailView(String error) {
        throw new FilterFailError(error);
    }
}
