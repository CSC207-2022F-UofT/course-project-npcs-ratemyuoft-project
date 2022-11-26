package InterfaceAdapters;

import Usecase.InputBoundary;
import Usecase.OutputBoundary;
import Usecase.ViewCourse;
import entity.Course;
import entity.Review;

import java.util.ArrayList;

public class Presenter implements OutputBoundary {

    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }

    @Override

    public void Display(ArrayList<Review> rlist, Course c){
        System.out.println(c.courseName);

        for (Review r: rlist){
            System.out.println(r.optionalComment);
        }

    }

}
