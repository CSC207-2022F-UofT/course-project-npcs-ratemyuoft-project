package InterfaceAdapter;

import Entities.Comment;
import Entities.CommentList;
import UI.MainFrame;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary {


    @Override
    public CommentList showComments(CommentList commentList) {
        return commentList;

    }

    @Override
    public boolean confirmComment(Comment comment) {
        return false;
    }

    // send to UI

    @Override
    public String outputMessage(String s) {
        return s;
    }


}
