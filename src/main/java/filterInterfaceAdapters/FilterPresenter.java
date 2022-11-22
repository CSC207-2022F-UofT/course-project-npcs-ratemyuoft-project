package filterInterfaceAdapters;

import entities.Course;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterResponseModel;

import java.util.List;

public class FilterPresenter implements FilterOutputBoundary {

    final FilterResponseModel filterResponseModel;

    public FilterPresenter(FilterResponseModel filterResponseModel) {
        this.filterResponseModel = filterResponseModel;
    }

    @Override
    public String outputMessage() {
        return filterResponseModel.message;
    }

    @Override
    public List<Course> outputCourse() {
        return filterResponseModel.courseList;
    }
}
