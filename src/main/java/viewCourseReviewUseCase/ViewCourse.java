package viewCourseReviewUseCase;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ViewCourse implements InputBoundary{
    public  CourseList courseList;
    public Course course;
    private ArrayList<Review> reviews;
    private OutputBoundary output;

    public ViewCourse(Gateway gateway, OutputBoundary output){
        try{
            courseList = gateway.importcourselist();
        } catch (IOException | ClassNotFoundException e){
            courseList = new CourseList();
        }
        this.output = output;
    }

    public void Displayinformation(CourseNameRequestModel coursenamereq){
        String courseName = coursenamereq.getCoursename();

        for (Course i: courseList){
            if (Objects.equals(i.courseName, courseName)) {
                this.course = i;
                break;
            }
        }

        if (this.course != null){
            this.reviews = this.course.GetReviews();
        }

        else{
            this.reviews = new ArrayList<Review>();
        }

        CourseListRequestModel courselistreq = new CourseListRequestModel(this.reviews, this.course);

        if (this.course != null){
            this.output.Display(courselistreq);
        }

        else {
            this.output.outputMessage("Course not in Directory");
        }


    }

}
