package InterfaceAdapter;

import DataStructures.OutPutData;
import UI.*;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary {

    UIShow uiShow;
    UIMessage uiMessage;


    @Override
    public void showComments(OutPutData outPutData) {
        uiShow = new ShowCommentsFrame();
        uiShow.showComments(outPutData.getComments());
    }



    @Override
    public boolean confirmComment(String comment) {
        return false;
    }

    // send to UI

    @Override
    public void outputMessage(String s) {
        uiMessage = new ShowMessageUI();
        uiMessage.showMessage(s);


    }


}
