import CLI.BootCLI;
import CLI.BootCLIInterface;
import dataBase.DataBase;
import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.*;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, InvalidInputException {
        Presenter presenter = new Presenter();
        OutputBoundary outputBoundary = presenter;
        DataAccess dataAccess = new DataBase();
        InputBoundary inputBoundary =new Interactor(outputBoundary,dataAccess);
        Controller controller = new Controller(inputBoundary);
        BootCLIInterface bootCLIInterface = new BootCLI();
        bootCLIInterface.boot(outputBoundary,dataAccess,inputBoundary,controller,presenter);



    }
}
