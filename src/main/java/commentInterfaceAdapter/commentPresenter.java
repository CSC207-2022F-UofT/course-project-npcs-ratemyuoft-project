package commentInterfaceAdapter;

import commentDataStructures.commentOutPutData;
import commentUI.*;
import commentUseCase.commentOutputBoundary;

public class commentPresenter implements commentOutputBoundary {

    commentUIShow uiShow;
    commentUIMessage uiMessage;


    /**
     * @param commentOutPutData output data
     * calls ui and open a frame with output data
     */
    @Override
    public void showComments(commentOutPutData commentOutPutData) {
        uiShow = new commentShowCommentsFrame();
        uiShow.showComments(commentOutPutData.getComments());
    }


    // send to UI

    /**
     * @param s
     * make a new UI class which will show the message.
     */
    @Override
    public void outputMessage(String s) {
        uiMessage = new commentShowMessageUI();
        uiMessage.showMessage(s);


    }


}
