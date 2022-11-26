package InterfaceAdapters;

import Usecase.Gateway;
import Usecase.InputBoundary;
import Usecase.OutputBoundary;
import Usecase.ViewCourse;
import entity.Review;

import java.util.ArrayList;

public class Controller {
    private String coursename;

    private Gateway gateway;

    private OutputBoundary outputBoundary;

    public Controller(String coursename, Gateway gateway, OutputBoundary outputBoundary){

        this.coursename = coursename;
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    public void Display(){
        InputBoundary ip = new ViewCourse(this.coursename, this.gateway, this.outputBoundary);

    }
}
