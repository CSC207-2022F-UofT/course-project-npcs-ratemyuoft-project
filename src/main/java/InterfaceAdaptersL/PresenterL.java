package InterfaceAdaptersL;

import LikeReviewShawn.OutputBoundaryL;
import LikeReviewShawn.OutputBoundaryL;

public class PresenterL implements OutputBoundaryL {
    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }
}
