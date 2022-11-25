import CLI.BootCLI;
import CLI.BootCLIInterface;
import DataBase.DataBase;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.DataAccess;
import UseCase.InputBoundary;
import UseCase.Interactor;
import UseCase.OutputBoundary;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Presenter presenter = new Presenter();
        OutputBoundary outputBoundary = presenter;
        DataAccess dataAccess = new DataBase();
        InputBoundary inputBoundary =new Interactor(outputBoundary,dataAccess);
        Controller controller = new Controller(inputBoundary);
        BootCLIInterface bootCLIInterface = new BootCLI();
        bootCLIInterface.boot(outputBoundary,dataAccess,inputBoundary,controller,presenter);


    }
}
