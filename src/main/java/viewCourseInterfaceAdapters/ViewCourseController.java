package viewCourseInterfaceAdapters;

import courseDataBase.CourseDataBaseGateway;
import viewCourseUsecase.ViewCourseInputBoundary;
import viewCourseUsecase.ViewCourseInteracter;
import viewCourseUsecase.ViewCourseOutputBoundary;

import java.util.ArrayList;

public class ViewCourseController {
    private String coursename;

    private CourseDataBaseGateway gateway;

    private ViewCourseOutputBoundary outputBoundary;

    public ViewCourseController(String coursename, CourseDataBaseGateway gateway, ViewCourseOutputBoundary outputBoundary){

        this.coursename = coursename;
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    public void displayCourseDetails(){
        ViewCourseInputBoundary ip = new ViewCourseInteracter(this.coursename, this.gateway, this.outputBoundary);
        ip.displayInformation();
    }
}