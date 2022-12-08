package commentUseCase;

import commentDataStructures.commentInPutData;

import java.io.IOException;

public interface commentInputBoundary {

    void showComments() throws IOException, ClassNotFoundException;
    void addComment(commentInPutData commentInPutData) throws InvalidInputException, IOException;
    void outputMessage(String s);

}
