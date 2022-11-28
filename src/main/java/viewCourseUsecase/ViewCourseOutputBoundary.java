package viewCourseUsecase;
import entities.Course;
import entities.Review;

import java.util.ArrayList;

public interface ViewCourseOutputBoundary {
    void outputMessage(String s);

    void Display(ArrayList<Review> rlist, Course c);
}
