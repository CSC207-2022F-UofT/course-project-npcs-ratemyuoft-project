package InterfaceAdapters;

import DataBase.DataAccess;
import Usecase.Gateway;
import Usecase.InputBoundary;
import Usecase.RegisterCourse;
import Usecase.ViewCourse;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TempUI {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DataAccess d = new DataAccess();

        Review r = new Review(4, "f");
        Review r1 = new Review(3, "3");
        Review r2 = new Review(1, "g");


        Course mat = new Course("Mat137", "Math");
        Course cs = new Course("CSC108", "Math");
        Course stats = new Course("Sta257", "Math");

        mat.AddReview(r);
        mat.AddReview(r1);
        mat.AddReview(r2);

        cs.AddReview(r);

        stats.AddReview(r);
        stats.AddReview(r1);

        RegisterCourse reg = new RegisterCourse(mat, d);
        RegisterCourse reg1 = new RegisterCourse(cs, d);
        RegisterCourse regy = new RegisterCourse(stats, d);

        CourseList c = d.importcourselist();

        ViewCourse v = new ViewCourse(mat, d);
        System.out.println(v.getReviews());
    }
}
