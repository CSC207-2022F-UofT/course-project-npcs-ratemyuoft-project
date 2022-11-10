package Entities;
import HashMap;

public class CourseDatabase {
    public Hashmap<Course, ArrayList<Review>> Courses = new Hashmap<Course, ArrayList<Review>>();
    public void CourseDatabase(){

        this.Courses = Courses
    }

    public AddCourse(Course course){
        ArrayList<Review> empty = new ArrayList<Review>;
        this.Courses.put(course, empty)
    }

    public AddReview(Course course, Review review){
        this.Courses.get(course).add(review);
    }


}
