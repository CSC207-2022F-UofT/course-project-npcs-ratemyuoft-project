package logInInterfaceAdapter;

/**
 * ViewModel is the class that allows us not to cycle messages we want to display from Controller through the whole
 * project. Instead, it becomes Controller->ViewModel->Presenter
 */
public class LogInViewModel {



    LogInPresenter logInPresenter = new LogInPresenter();

    void outputFromController(String s){
        logInPresenter.outputMessage(s);
    }



}
