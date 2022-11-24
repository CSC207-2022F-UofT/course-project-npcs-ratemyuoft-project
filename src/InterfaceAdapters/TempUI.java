package InterfaceAdapters;

import DataBase.DataAccess;
import Usecase.Gateway;
import Usecase.InputBoundary;
import Usecase.ViewCourse;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TempUI {
    public static void main(String[] args){
        Course course = new Course("Csc207", "Computer Science");
        Review rev = new Review(3);
        ArrayList<Review> revs = new ArrayList<>();
        revs.add(rev);
        HashMap<Course, ArrayList<Review>> courses = new HashMap<>();
        courses.put(course, revs);
        CourseList courselist = new CourseList(courses);

        Gateway gateway = new DataAccess();
        InputBoundary inputBoundary = new ViewCourse(course, gateway);
        Controller controller = new Controller(inputBoundary);

        System.out.println(controller.getReviews());
    }
}
