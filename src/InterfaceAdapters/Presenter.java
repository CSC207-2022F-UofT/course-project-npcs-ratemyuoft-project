package InterfaceAdapters;

import Usecase.OutputBoundary;

public class Presenter implements OutputBoundary {

    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }

}
