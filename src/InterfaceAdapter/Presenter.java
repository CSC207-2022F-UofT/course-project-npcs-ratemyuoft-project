package InterfaceAdapter;

import Entities.Comment;
import Entities.CommentList;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary {


    @Override
    public CommentList showComment(CommentList commentList) {
        return commentList;
    }

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
