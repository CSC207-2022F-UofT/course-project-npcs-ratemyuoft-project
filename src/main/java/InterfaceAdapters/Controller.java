package InterfaceAdapters;

import UsecaseShawn.Gateway;
import UsecaseShawn.InputBoundary;
import UsecaseShawn.OutputBoundary;
import UsecaseShawn.ViewCourse;

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
        ip.Displayinformation();
    }
}
