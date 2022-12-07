package viewCourseReviewUseCase;

import viewCourseDataStructures.CourseNameRequestModel;

public interface ViewCourseInputBoundary {
    /**
     * ViewCourseInputBoundary is an InputBoundary Interface for ViewCourseInteractor.
     * It has one method, Displayinformation, which takes in CourseNameRequestModel
     */

    void Displayinformation(CourseNameRequestModel coursenamereq);
}
