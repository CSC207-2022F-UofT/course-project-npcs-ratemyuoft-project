package UseCase;

import Entities.Comment;

public interface OutputBoundary {
    void confirmComment(Comment comment);
    void outputMessage(String s);
}
