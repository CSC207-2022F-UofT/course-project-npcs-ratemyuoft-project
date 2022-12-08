package dataStructures.viewCourseDataStructures;

import entities.Course;
import entities.Review;

import java.util.ArrayList;

public class CourseListResponseModelHelp {
    /**
     * CourseListResponseModelHelp: Helper to keep Use Case Clean and ensure that the Response Model does not
     * take in any Entities
     * CourseListResponseModelHelp: Takes in List of Reviews and Course and instatiates a coursename and List with
     * ReviewInformation types.
     */
    public ArrayList<ReviewInformation> reviewlist;
    public String coursename;

    public CourseListResponseModelHelp(ArrayList<Review> reviewlist, Course course) {
        this.coursename = course.getCourseName();
        this.reviewlist = new ArrayList<>();

        for (Review r : reviewlist) {
            ReviewInformation ri = new ReviewInformation(r.getReviewID(), r.getRating(), r.getOptionalComment(), r.getNumberOfLikes());
            this.reviewlist.add(ri);
        }

    }
}
