package viewCourseDataStructures;

import entity.Course;
import entity.Review;

import java.util.ArrayList;

public class CourseListResponseModelHelp {
    // Takes in a Course, and a list of its reviews and saves it as a datatype
    public ArrayList<ReviewInformation> reviewlist;
    public String coursename;

    public CourseListResponseModelHelp(ArrayList<Review> reviewlist, Course course) {
        this.coursename = course.courseName;
        this.reviewlist = new ArrayList<ReviewInformation>();

        for (Review r : reviewlist) {
            ReviewInformation ri = new ReviewInformation(r.getName(), r.getRating(), r.getComment(), r.getNumberOfLikes());
            this.reviewlist.add(ri);
        }

    }
}
