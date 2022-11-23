import DataBase.DataAccess;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UI.MainFrame;
import UseCase.Gateway;
import UseCase.InputBoundary;
import UseCase.Interactor;
import UseCase.OutputBoundary;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Gateway gateway = new DataAccess();
        OutputBoundary outputBoundary = new Presenter();
        InputBoundary inputBoundary = new Interactor(outputBoundary,gateway);
        Controller controller = new Controller(inputBoundary);
        MainFrame mainFrame = new MainFrame(controller,outputBoundary);


    }

}
