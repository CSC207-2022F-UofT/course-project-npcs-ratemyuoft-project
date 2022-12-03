package viewCourseInterfaceAdapters;

import viewCourseReviewUseCase.CourseNameRequestModel;
import viewCourseReviewUseCase.InputBoundary;

public class Controller {

    public InputBoundary ip;
    public Controller (InputBoundary ip){
        this.ip = ip;
    }
    public void DisplayReviews(String coursename){
        CourseNameRequestModel coursenamereq = new CourseNameRequestModel(coursename);
        ip.Displayinformation(coursenamereq);

    }
}
