import commentDataBase.commentDataAccess;
import commentInterfaceAdapter.commentController;
import commentInterfaceAdapter.commentPresenter;
import commentUI.commentMainFrame;
import commentUseCase.commentGateway;
import commentUseCase.commentInputBoundary;
import commentUseCase.commentInteractor;
import commentUseCase.commentOutputBoundary;

import java.io.IOException;

public class CommentMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        commentGateway commentGateway = new commentDataAccess("commentsFile.sav");
        commentOutputBoundary commentOutputBoundary = new commentPresenter();
        commentInputBoundary commentInputBoundary = new commentInteractor(commentOutputBoundary, commentGateway);
        commentController controller = new commentController(commentInputBoundary);
        new commentMainFrame(controller,"Review Name");


    }

}
