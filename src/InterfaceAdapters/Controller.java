package InterfaceAdapters;

import Usecase.InputBoundary;
import entity.Review;

import java.util.ArrayList;

public class Controller {
    private final InputBoundary inputBoundary;

    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public ArrayList<Review> getReviews(){
        return inputBoundary.getReviews();
    }
}
