package InterfaceAdapter;

import Entities.Comment;
import Entities.CommentList;
import UI.CommentFrame;
import UseCase.OutputBoundary;

public class Presenter(CommentFrame) implements OutputBoundary {


    @Override
    public CommentList showComments() {

    }

    // send to UI
    @Override
    public void confirmComment(Comment comment) {


    }

    @Override
    public void outputMessage(String s) {
        return s;
    }


}
