package entity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class CourseList implements Serializable {
    public ArrayList<Course> Courses = new ArrayList<>();

    public CourseList(ArrayList<Course> courseList){
        this.Courses = courseList;
    }

    public CourseList(){
        this.Courses = new ArrayList<>();
    }

    public void AddCourse(Course course){
        this.Courses.add(course);
    }
}
