package usecase;

import entities.Course;
import entities.CourseList;

import java.io.IOException;
import java.util.List;

/**
 * CourseDataAccessInterface is the Interface for database gateways related to course data.
 */
public interface CourseDataAccessInterface {

    /**
     * saveCourse is the action of saving the changes made into the course database
     * @param courseList is new updated course list
     * @throws IOException
     * @throws NullPointerException
     */
    void saveCourse(CourseList courseList) throws IOException, NullPointerException;

    /**
     * importCourses is the method of accessing the database's data.
     * @return the course list that we want to operate or conduct use cases on.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    CourseList importCourseList() throws IOException, ClassNotFoundException;
    Course getCourseWithName(String s) throws InvalidInputException;

    void generateTempCourses2() throws IOException, NullPointerException;

    List<String> getCourseNames();

}