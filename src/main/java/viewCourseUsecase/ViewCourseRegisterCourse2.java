package viewCourseUsecase;

import courseDataBase.CourseDataBaseGateway;
import entities.Course;
import entities.CourseList;

import java.io.IOException;

public class ViewCourseRegisterCourse2 {

    public ViewCourseRegisterCourse2(CourseList C, CourseDataBaseGateway d) throws IOException, ClassNotFoundException {
        d.saveCourse(C);
    }




}
