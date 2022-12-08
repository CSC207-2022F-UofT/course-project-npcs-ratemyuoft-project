package useCases.viewCourseReviewUseCase;

import dataStructures.viewCourseDataStructures.CourseListResponseModel;

public interface ViewCourseOutputBoundary {
    /**
     * ViewCourseOutputBoundary is an OutputBoundary Interface for the Presenter.
     * outputMessage takes in a String
     * Display Takes in a CourselistResponse Model
     */
    void outputMessage(String s);

    void Display(CourseListResponseModel courselistresponse);
}
