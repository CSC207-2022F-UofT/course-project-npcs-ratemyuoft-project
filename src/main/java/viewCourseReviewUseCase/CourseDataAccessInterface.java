package viewCourseReviewUseCase;

import entity.CourseList;
import java.io.IOException;

public interface CourseDataAccessInterface {
    // Interface for the DataAccess
    CourseList importcourselist() throws IOException, ClassNotFoundException;
    void SaveCourse(CourseList courseList) throws IOException, ClassNotFoundException;
}
