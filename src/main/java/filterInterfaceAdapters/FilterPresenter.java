package filterInterfaceAdapters;

import entities.CourseList;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterResponseModel;

public class FilterPresenter implements FilterOutputBoundary {

    @Override
    public FilterResponseModel filterSuccessView(CourseList courseList) {
        FilterResponseModel frs = new FilterResponseModel(courseList);
        System.out.println(frs);
        return frs;
    }

    @Override
    public FilterResponseModel filterFailView(String error) {
        throw new FilterFailError(error);
    }
}
