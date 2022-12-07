package registerCourse;

import courseDataBase.CourseDataAccess;
import entities.CourseList;

import java.io.IOException;

public class RegisterCourse2 {

    public RegisterCourse2(CourseList C, CourseDataAccess d) throws IOException, ClassNotFoundException {
        d.saveCourse(C);
    }




}
