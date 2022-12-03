package viewCourseInterfaceAdapters;

import viewCourseReviewUseCase.CourseNameRequestModel;
import viewCourseReviewUseCase.InputBoundary;

public class Controller {
    // Takes in an Input Boundary
    public InputBoundary ip;
    public Controller (InputBoundary ip){
        this.ip = ip;
    }
    public void DisplayReviews(String coursename){
        //Takes in a coursename and gives it to the inputboundary Displayinformation method
        CourseNameRequestModel coursenamereq = new CourseNameRequestModel(coursename);
        ip.Displayinformation(coursenamereq);

    }
}
