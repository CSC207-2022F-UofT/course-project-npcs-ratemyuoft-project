package registerCourse;

import courseDatabase.CourseDataAccess;
import entity.CourseList;

import java.io.IOException;

public class RegisterCourse2 {

    public RegisterCourse2(CourseList C, CourseDataAccess d) throws IOException, ClassNotFoundException {
        d.SaveCourse(C);
    }




}
