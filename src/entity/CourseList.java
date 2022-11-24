package entity;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class CourseList {
    public Map<Course, ArrayList<Review>> Courses = new HashMap<>();

    public CourseList(HashMap courseList){
        this.Courses = courseList;
    }

    public CourseList(){
        this.Courses = new HashMap<>();
    }

    public void AddCourse(Course course){
        ArrayList<Review> empty = new ArrayList<Review>();
        this.Courses.put(course, empty);
    }

    public void AddReview(Course course, Review review){
        this.Courses.get(course).add(review);
    }

    public ArrayList<Review> getReviews(Course course){
        return this.Courses.get(course);

    }
}
