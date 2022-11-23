package UseCase;

import Entities.CommentList;

import java.io.IOException;

public interface Gateway {

    CommentList importComment() throws IOException, ClassNotFoundException;

    void saveComment(CommentList commentList) throws IOException;
}
