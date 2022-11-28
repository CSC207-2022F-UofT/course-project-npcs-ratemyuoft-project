package filterUseCases;
import entities.Course;
import entities.CourseList;
import filterInterfaceAdapters.FilterFailError;

public interface FilterOutputBoundary {

    FilterResponseModel filterSuccessView(CourseList courseList);

    FilterResponseModel filterFailView (String s) throws FilterFailError;
}
