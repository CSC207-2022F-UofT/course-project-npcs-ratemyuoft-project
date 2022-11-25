package UseCase;

import Entities.Comment;
import Entities.CommentList;

public interface OutputBoundary {

    void showComments(CommentList commentList);

    boolean confirmComment(Comment comment);
    void outputMessage(String s);
}
