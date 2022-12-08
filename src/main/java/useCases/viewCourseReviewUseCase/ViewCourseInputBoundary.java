package useCases.viewCourseReviewUseCase;

import dataStructures.viewCourseDataStructures.CourseNameRequestModel;

public interface ViewCourseInputBoundary {
    /**
     * ViewCourseInputBoundary is an InputBoundary Interface for ViewCourseInteractor.
     * It has one method, Displayinformation, which takes in CourseNameRequestModel
     */

    void Displayinformation(CourseNameRequestModel coursenamereq) throws ClassNotFoundException;
}
