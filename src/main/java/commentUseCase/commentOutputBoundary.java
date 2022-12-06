package commentUseCase;

import commentDataStructures.commentOutPutData;

public interface commentOutputBoundary {

    void showComments(commentOutPutData commentOutPutData);

    void outputMessage(String s);
}
