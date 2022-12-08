package interfaceAdapters.viewCourseInterfaceAdapters;

import dataStructures.viewCourseDataStructures.CourseNameRequestModel;
import useCases.viewCourseReviewUseCase.ViewCourseInputBoundary;

public class ViewCourseController {
    /**
     * ViewCourseController is the Controller for View Course, takes in an InputBoundary
     * DisplayReview takes in a Coursename, creates a CourseNameRequestModel, and gives it to the
     * DisplayInfromation method in the Input Boundary
     */
    public ViewCourseInputBoundary ip;
    public ViewCourseController(ViewCourseInputBoundary ip){
        this.ip = ip;
    }
    public void DisplayReviews(String coursename) throws ClassNotFoundException {
        CourseNameRequestModel coursenamereq = new CourseNameRequestModel(coursename);
        ip.Displayinformation(coursenamereq);

    }
}
