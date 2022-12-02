package UseCase;

import DataStructures.InPutData;

import java.io.IOException;

public interface InputBoundary {

    void showComments() throws IOException, ClassNotFoundException;
    void addComment(InPutData inPutData) throws InvalidInputException, IOException;
    void editComment(int commentNum, String s) throws InvalidInputException, CommentNotInListException;
    void outputMessage(String s);

}
