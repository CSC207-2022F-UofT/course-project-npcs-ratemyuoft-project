package commentUseCase;

import commentDataStructures.commentInPutData;

import java.io.IOException;

public interface commentInputBoundary {

    void showComments() throws IOException, ClassNotFoundException;
    void addComment(commentInPutData commentInPutData) throws InvalidInputException, IOException;
    void editComment(int commentNum, String s) throws InvalidInputException;
    void outputMessage(String s);

}
