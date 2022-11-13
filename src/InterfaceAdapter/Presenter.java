package InterfaceAdapter;

import Entities.Comment;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary {




    @Override
    public void confirmMessage(Comment comment) {
        System.out.println(comment);

    }
}
