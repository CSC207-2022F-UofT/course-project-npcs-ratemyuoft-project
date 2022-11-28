package filterUseCases;

import entities.CourseList;
import entities.Course;

import java.io.IOException;

public interface FilterDAGateway {

    void saveCourse(CourseList users) throws IOException, NullPointerException;

    CourseList importCourses() throws IOException, ClassNotFoundException;

}
