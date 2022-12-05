package viewCourseInterfaceAdapters;

import viewCourseReviewUseCase.CourseNameRequestModel;
import viewCourseReviewUseCase.ViewCourseInputBoundary;

public class ViewCourseController {
    // Takes in an Input Boundary
    public ViewCourseInputBoundary ip;
    public ViewCourseController(ViewCourseInputBoundary ip){
        this.ip = ip;
    }
    public void DisplayReviews(String coursename){
        //Takes in a coursename and gives it to the inputboundary Displayinformation method
        CourseNameRequestModel coursenamereq = new CourseNameRequestModel(coursename);
        ip.Displayinformation(coursenamereq);

    }
}
