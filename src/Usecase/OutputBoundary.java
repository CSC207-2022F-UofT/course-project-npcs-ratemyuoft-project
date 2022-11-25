package Usecase;
import entity.Review;

import java.util.ArrayList;

public interface OutputBoundary {
    void outputMessage(String s);

    ArrayList<Review> ReviewOutput(InputBoundary i);
}
