package InterfaceAdapter;

import Entities.Comment;
import Entities.CommentList;
import UI.*;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary {

    MainFrame mainFrame;
    UIShow uiShow;
    UIMessage uiMessage;


    @Override
    public void showComments(CommentList commentList) {
        uiShow = new ShowCommentsFrame();
        uiShow.showComments(commentList);
    }


    @Override
    public boolean confirmComment(Comment comment) {
        return false;
    }

    // send to UI

    @Override
    public void outputMessage(String s) {
        uiMessage = new ShowMessageUI();
        uiMessage.showMessage(s);


    }


}
