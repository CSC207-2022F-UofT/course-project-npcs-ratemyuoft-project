package filterUseCases;

import entities.CourseList;

import java.io.IOException;

public interface CourseDataAccessInterface {

    void saveCourse(CourseList courseList) throws IOException, NullPointerException;

    CourseList importCourses() throws IOException, ClassNotFoundException;

}
