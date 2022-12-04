package viewCourseReviewUseCase;
import entities.Course;
import entities.CourseList;
import entities.Review;
import viewCourseDataStructures.CourseListResponseModel;
import viewCourseDataStructures.CourseListResponseModelHelp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ViewCourseInteractor implements ViewCourseInputBoundary {
    public  CourseList courseList;
    public Course course;
    private ArrayList<Review> reviews;
    private ViewCourseOutputBoundary output;

    public ViewCourseInteractor(CourseDataAccessInterface courseDataAccessInterface, ViewCourseOutputBoundary output){
        // Takes in a gateway and output boundary, instantiates a courselist.
        try{
            courseList = courseDataAccessInterface.importcourselist();
        } catch (IOException | ClassNotFoundException e){
            courseList = new CourseList();
        }
        this.output = output;
    }

    public void Displayinformation(CourseNameRequestModel coursenamereq){
        // takes in a coursenameRequestModel and iterates through the courselist to find the Course that Matches, gives CourseListRequestModel to OutputBoundary
        String courseName = coursenamereq.getCoursename();

        for (Course i: courseList){
            if (Objects.equals(i.courseName, courseName)) {
                this.course = i;
                break;
            }
        }

        if (this.course != null){
            this.reviews = this.course.GetReviews();
            CourseListResponseModelHelp courselistreq = new CourseListResponseModelHelp(this.reviews, this.course);
            CourseListResponseModel courselistresponse = new
                    CourseListResponseModel(courselistreq.reviewlist, courselistreq.coursename);
            this.output.Display(courselistresponse);
        }

        else {
            this.output.outputMessage("Course not in Directory");
        }
    }
}
