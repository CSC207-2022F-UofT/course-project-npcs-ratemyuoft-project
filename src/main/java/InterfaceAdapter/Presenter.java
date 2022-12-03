package InterfaceAdapter;

import DataStructures.OutPutData;
import UI.*;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary {

    UIShow uiShow;
    UIMessage uiMessage;


    /**
     * @param outPutData output data
     * calls ui and open a frame with output data
     */
    @Override
    public void showComments(OutPutData outPutData) {
        uiShow = new ShowCommentsFrame();
        uiShow.showComments(outPutData.getComments());
    }


    // send to UI

    /**
     * @param s
     * make a new UI class which will show the message.
     */
    @Override
    public void outputMessage(String s) {
        uiMessage = new ShowMessageUI();
        uiMessage.showMessage(s);


    }


}
