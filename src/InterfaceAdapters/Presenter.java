package InterfaceAdapters;

import Usecase.InputBoundary;
import Usecase.OutputBoundary;
import Usecase.ViewCourse;
import entity.Review;

import java.util.ArrayList;

public class Presenter implements OutputBoundary {

    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }

    @Override

    public ArrayList<Review> ReviewOutput(InputBoundary i){
        return i.getReviews();
    }

}
