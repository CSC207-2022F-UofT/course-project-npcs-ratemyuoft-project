package interfaceAdapter;

/**
 * ViewModel is the class that allows us not to cycle messages we want to display from Controller through the whole
 * project. Instead, it becomes Controller->ViewModel->Presenter
 */
public class ViewModel {



    Presenter presenter = new Presenter();

    void outputFromController(String s){
        presenter.outputMessage(s);
    }



}
