package UsecaseShawn;

import DataBaseShawn.DataAccess;
import entity.CourseList;

import java.io.IOException;

public class RegisterCourse2 {

    public RegisterCourse2(CourseList C, DataAccess d) throws IOException, ClassNotFoundException {
        d.SaveCourse(C);
    }




}
