package viewCourseReviewUseCase;

import viewCourseDataStructures.CourseListResponseModel;
import viewCourseDataStructures.CourseListResponseModelHelp;

public interface ViewCourseOutputBoundary {
    // Interface for Presenter
    void outputMessage(String s);

    void Display(CourseListResponseModel courselistresponse);
}
