package Usecase;
import entity.Course;
import entity.Review;

import java.util.ArrayList;

public interface OutputBoundary {
    void outputMessage(String s);

    void Display(ArrayList<Review> rlist, Course c);
}
