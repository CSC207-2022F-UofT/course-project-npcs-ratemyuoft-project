package courseDataBase;

import entities.CourseList;

import java.io.IOException;

public interface CourseDataBaseGateway {

    void saveCourse(CourseList courseList) throws IOException, NullPointerException;

    CourseList importCourses() throws IOException, ClassNotFoundException;

}
