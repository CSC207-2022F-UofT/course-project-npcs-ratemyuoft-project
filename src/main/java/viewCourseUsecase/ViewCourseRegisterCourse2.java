package viewCourseUsecase;

import filterUseCases.CourseDataAccessInterface;
import entities.CourseList;

import java.io.IOException;

public class ViewCourseRegisterCourse2 {

    public ViewCourseRegisterCourse2(CourseList C, CourseDataAccessInterface d) throws IOException, ClassNotFoundException {
        d.saveCourse(C);
    }




}
