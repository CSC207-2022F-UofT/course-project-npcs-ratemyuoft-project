package UseCase;

import Entities.Comment;
import Entities.CommentList;

public interface OutputBoundary {
    void showComments();
    void confirmComment(Comment comment);
    void outputMessage(String s);
}
