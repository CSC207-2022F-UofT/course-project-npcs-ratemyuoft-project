import DataBaseShawn.DataAccess;
import InterfaceAdapters.Controller;
import InterfaceAdapters.Presenter;
import InterfaceAdaptersL.ControllerL;
import InterfaceAdaptersL.PresenterL;
import java.io.IOException;

public class MainShawn {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataAccess d = new DataAccess();
        DataAccess d1 = new DataAccess();

        Presenter p = new Presenter();
        PresenterL pL = new PresenterL();

        ControllerL controllaL = new ControllerL("Review1", d1, pL);
        Controller controla = new Controller();

        controllaL.Like();
        controla.Display("Mat137", d, p);
    }
}
