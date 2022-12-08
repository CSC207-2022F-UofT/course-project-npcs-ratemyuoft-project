package viewCourseReviewUseCase;

import courseDataBase.CourseDataAccessInterface;
import entities.Course;
import entities.CourseList;
import entities.Review;
import viewCourseDataStructures.CourseListResponseModel;
import viewCourseDataStructures.CourseListResponseModelHelp;
import viewCourseDataStructures.CourseNameRequestModel;

import java.io.IOException;
import java.util.ArrayList;

public class ViewCourseInteractor implements ViewCourseInputBoundary {
    /**
     * ViewCourseInteractor: Interactor for ViewCourse Usecase
     * ViewCourseInteractor: Takes in CourseDataAccessInterface and OutputBoundary, and Imports a Courselist
     * Displayinformation: Takes in a CourseNameRequestModel and instantiates a String, Iterates throught through
     * the courselist and finds the course that matches. Creates a CourselistResponseModel and sends it to the
     * OutputBoundary.
     */
    public  CourseList courseList;
    public Course course;
    private ArrayList<Review> reviews;
    private ViewCourseOutputBoundary output;

    public ViewCourseInteractor(CourseDataAccessInterface courseDataAccessInterface, ViewCourseOutputBoundary output){
        try{
            courseList = courseDataAccessInterface.importCourses();
        } catch (IOException | ClassNotFoundException e){
            courseList = new CourseList();
        }
        this.output = output;
    }

    public void Displayinformation(CourseNameRequestModel coursenamereq) {
        String courseName = coursenamereq.getCoursename();

        for (Course i: courseList){
            if (i.getCourseName().equals(courseName)) {
                this.course = i;
                break;
            }
        }

        if (this.course != null){
            this.reviews = this.course.getReviews();
            CourseListResponseModelHelp courselistreq = new CourseListResponseModelHelp(this.reviews, this.course);
            CourseListResponseModel courselistresponse = new
                    CourseListResponseModel(courselistreq.reviewlist, courselistreq.coursename);
            this.output.Display(courselistresponse);
        }
    }
}
