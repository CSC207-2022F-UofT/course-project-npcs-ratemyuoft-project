package viewCourseReviewUseCase;

public class CourseNameRequestModel {
    // Takes in a Course Name and stors it in a data structure
    String coursename;

    public CourseNameRequestModel(String coursename){
        this.coursename = coursename;
    }

    public String getCoursename(){
        return this.coursename;
    }
}
