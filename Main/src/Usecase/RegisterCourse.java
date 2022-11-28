package Usecase;

import DataBase.DataAccess;
import entity.Course;
import entity.CourseList;

import java.io.IOException;
import java.util.Objects;

public class RegisterCourse {
    public Course C;

    public RegisterCourse(Course C, DataAccess gateway) throws IOException, ClassNotFoundException {


        try{
            CourseList courselist = gateway.importcourselist();
            for (Course c: courselist){
                Boolean inlist = Boolean.FALSE;
                if (C.courseName == c.courseName){
                    inlist = Boolean.TRUE;
                }
                if (inlist == Boolean.FALSE){
                    courselist.AddCourse(C);
                }
            }

            gateway.SaveCourse(courselist);

        } catch (Exception e) {
            CourseList courselist = new CourseList();
            courselist.AddCourse(C);
            gateway.SaveCourse(courselist);
        }







    }
}

