package registerCourse;

import courseDatabase.CourseDataAccessShawn;
import entities.CourseList;

import java.io.IOException;

public class RegisterCourse2 {

    public RegisterCourse2(CourseList C, CourseDataAccessShawn d) throws IOException, ClassNotFoundException {
        d.SaveCourse(C);
    }




}
