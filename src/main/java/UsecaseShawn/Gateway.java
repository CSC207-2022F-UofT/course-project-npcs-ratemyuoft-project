package UsecaseShawn;

import entity.CourseList;
import java.io.IOException;

public interface Gateway {
    CourseList importcourselist() throws IOException, ClassNotFoundException;
    void SaveCourse(CourseList courseList) throws IOException, ClassNotFoundException;
}