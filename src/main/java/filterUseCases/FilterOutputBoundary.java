package filterUseCases;
import entities.Course;
import entities.CourseList;
import filterInterfaceAdapters.FilterFailError;

import java.util.List;

public interface FilterOutputBoundary {

    FilterResponseModel filterSuccessView(CourseList courseList);

    FilterResponseModel filterFailView (String s) throws FilterFailError;
}
