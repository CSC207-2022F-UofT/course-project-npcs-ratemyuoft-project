package viewCourseReviewUseCase;

public class CourseNameRequestModel {
    String coursename;

    public CourseNameRequestModel(String coursename){
        this.coursename = coursename;
    }

    public String getCoursename(){
        return this.coursename;
    }
}
