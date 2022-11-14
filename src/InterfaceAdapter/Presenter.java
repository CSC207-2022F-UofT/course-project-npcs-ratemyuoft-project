package InterfaceAdapter;

import Entities.Comment;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary {


    // send to UI
    @Override
    public void confirmComment(Comment comment) {
        System.out.println(comment);

    }

    @Override
    public void outputMessage(String s) {
        System.out.println(s);

    }


}
