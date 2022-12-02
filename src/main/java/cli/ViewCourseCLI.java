package cli;

import java.io.IOException;
import java.util.Scanner;

import DataBaseShawn.DataAccess;
import InterfaceAdapters.Controller;
import InterfaceAdapters.Presenter;
import useCase.InvalidInputException;

public class ViewCourseCLI {
    public void viewcourse(Scanner scanner) throws IOException, ClassNotFoundException, InvalidInputException {
        Presenter presenter = new Presenter();
        Controller controller = new Controller();
        DataAccess dataaccess = new DataAccess();
        System.out.println("Enter Course Name Please = > " + "\n");

        try {
            controller.Display(scanner.next(), dataaccess, presenter);

        } catch (Exception e) {
            System.out.println("Try Again");
        }
    }
}
