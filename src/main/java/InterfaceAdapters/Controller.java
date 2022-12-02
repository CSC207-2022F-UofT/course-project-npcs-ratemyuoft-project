package InterfaceAdapters;

import UsecaseShawn.Gateway;
import UsecaseShawn.InputBoundary;
import UsecaseShawn.OutputBoundary;
import UsecaseShawn.ViewCourse;

public class Controller {
    private String coursename;

    private Gateway gateway;

    private OutputBoundary outputBoundary;

    public void Display(String coursename, Gateway gateway, OutputBoundary outputBoundary){
        InputBoundary ip = new ViewCourse(coursename, gateway, outputBoundary);
        try {
            ip.Displayinformation();
        } catch (Exception e){
            outputBoundary.outputMessage("No Course with This Name");
        }

    }
}
