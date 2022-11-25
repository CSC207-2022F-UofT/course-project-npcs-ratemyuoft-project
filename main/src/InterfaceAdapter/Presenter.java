package InterfaceAdapter;

import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary{


    @Override
    public void showUsers() {

    }


    @Override
    public String outputMessage(String s) {
        return s;
    }
}
