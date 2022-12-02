package viewCourseInterfaceAdapters;

import filterUseCases.CourseDataAccessInterface;
import viewCourseUsecase.ViewCourseInputBoundary;
import viewCourseUsecase.ViewCourseInteracter;
import viewCourseUsecase.ViewCourseOutputBoundary;

public class ViewCourseController {
    private String coursename;

    private CourseDataAccessInterface gateway;

    private ViewCourseOutputBoundary outputBoundary;

    public ViewCourseController(String coursename, CourseDataAccessInterface gateway, ViewCourseOutputBoundary outputBoundary){

        this.coursename = coursename;
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    public void displayCourseDetails(){
        ViewCourseInputBoundary ip = new ViewCourseInteracter(this.coursename, this.gateway, this.outputBoundary);
        ip.displayInformation();
    }
}