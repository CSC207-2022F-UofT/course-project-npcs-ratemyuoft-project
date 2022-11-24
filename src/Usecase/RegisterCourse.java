package Usecase;

import DataBase.DataAccess;
import entity.Course;
import entity.CourseList;

import java.io.IOException;

public class RegisterCourse {
    public Course C;

    public RegisterCourse(Course C, DataAccess gateway) throws IOException, ClassNotFoundException {
        CourseList courselist = gateway.importcourselist();
        courselist.AddCourse(C);
        gateway.saveComment(courselist);
    }
}
