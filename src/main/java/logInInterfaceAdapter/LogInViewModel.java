package logInInterfaceAdapter;

/**
 * ViewModel is the class that allows us not to cycle messages we want to display from Controller through the whole
 * project. Instead, it becomes LogInController->LogInViewModel->LogInPresenter
 * <p>
 *
 * In other words, LogInViewModel is a bridge between LogInController and LogInPresenter in case any error message
 * needs to be displayed.
 * <p>
 * NOTE: Testing of this class was omitted too, as it forwards the call to LogInPresenter.
 * !!!Please refer to "NOTE" in LogInPresenter
 */
public class LogInViewModel {

    /**
     * The initialisation of LogInPresenter is needed to call the only method initialised in this class.
     */
    LogInPresenter logInPresenter = new LogInPresenter();

    /**
     * @param s is an error message that needs to be passed from LogInController and displayed.
     * <p>
     * outputFromController is a method that passes error message from LogInController to LogInPresenter for the
     * message to be displayed in the CLI and let user know what has gone wrong.
     */
    public void outputFromController(String s){
        logInPresenter.outputMessage(s+ "\n");
    }



}
