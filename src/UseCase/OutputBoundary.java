package UseCase;

import Entities.Comment;
import Entities.CommentList;

public interface OutputBoundary {
    CommentList showComment(CommentList commentList);
    void confirmComment(Comment comment);
    void outputMessage(String s);
}
