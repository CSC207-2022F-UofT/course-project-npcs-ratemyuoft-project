package UseCase;

import Entities.Comment;
import Entities.CommentList;

public interface OutputBoundary {

    CommentList showComments(CommentList commentList);

    boolean confirmComment(Comment comment);
    String outputMessage(String s);
}
