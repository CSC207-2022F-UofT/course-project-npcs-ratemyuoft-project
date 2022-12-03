package viewCourseReviewUseCase;

import entity.Course;
import entity.Review;

import java.util.ArrayList;

public class CourseListRequestModel {
    // Takes in a Course, and a list of its reviews and saves it as a datatype
    public ArrayList<Review> reviewlist;
    public Course course;

    public CourseListRequestModel(ArrayList<Review> reviewlist, Course course){
        this.reviewlist = reviewlist;
        this.course = course;
    }

    public ArrayList<Review> getReviewlist(){
        return this.reviewlist;
    }
    public Course getCourse(){
        return this.course;
    }
}
