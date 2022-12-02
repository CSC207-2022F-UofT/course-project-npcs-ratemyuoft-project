package InterfaceAdapters;

import entity.Course;
import entity.Review;

import java.util.ArrayList;

public class Presenter implements UsecaseShawn.OutputBoundary {

    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }

    @Override

    public void Display(ArrayList<Review> rlist, Course c){
        System.out.println("Course: " + c.courseName);

        for (Review r: rlist){
            System.out.println("");
            System.out.println("Name: " + r.Name);
            System.out.println("Rating: " + r.Rating);
            System.out.println("Comment: " + r.Comment);
            System.out.println("Likes: " + r.numberOfLikes);
        }
    }

}
