package commentUseCase;

import entities.CommentList;

import java.io.IOException;

public interface commentGateway {

    CommentList importComment() throws IOException, ClassNotFoundException;

    void saveComment(CommentList commentList) throws IOException;
}
