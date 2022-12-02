package viewCourseUsecase;

import filterUseCases.CourseDataAccessInterface;
import entities.Course;
import entities.CourseList;

import java.io.IOException;

public class RegisterCourse {
    public Course C;

    public RegisterCourse(Course C, CourseDataAccessInterface gateway) throws IOException, ClassNotFoundException {
        try{
            CourseList courselist = gateway.importCourses();
            for (Course c: courselist){
                Boolean inlist = Boolean.FALSE;
                if (C.courseName == c.courseName){
                    inlist = Boolean.TRUE;
                }
                if (inlist == Boolean.FALSE){
                    courselist.addCourse(C);
                }
            }

            gateway.saveCourse(courselist);

        } catch (Exception e) {
            CourseList courselist = new CourseList();
            courselist.addCourse(C);
            gateway.saveCourse(courselist);
        }
    }
}

