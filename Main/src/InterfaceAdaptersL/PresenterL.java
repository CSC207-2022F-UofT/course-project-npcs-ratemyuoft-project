package InterfaceAdaptersL;

import LikeReview.OutputBoundaryL;

public class PresenterL implements OutputBoundaryL {
    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }
}
