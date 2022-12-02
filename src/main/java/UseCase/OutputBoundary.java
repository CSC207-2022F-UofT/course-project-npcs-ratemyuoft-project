package UseCase;

import DataStructures.OutPutData;
import Entities.Comment;
import Entities.CommentList;

import java.util.ArrayList;

public interface OutputBoundary {

    void showComments(OutPutData outPutData);

    void outputMessage(String s);
}
