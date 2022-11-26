import DataBase.DataAccess;
import InterfaceAdapters.Controller;
import InterfaceAdapters.Presenter;
import Usecase.Gateway;
import Usecase.InputBoundary;
import Usecase.RegisterCourse;
import Usecase.ViewCourse;
import entity.Course;
import entity.CourseList;
import entity.Review;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataAccess d = new DataAccess();

        Review r = new Review(4, "I hate this Course");
        Review r1 = new Review(3, "This course is cool");
        Review r2 = new Review(1, "This course is bird");

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
        Presenter p = new Presenter();

        ViewCourse v = new ViewCourse("Mat137", d, p);

        v.Displayinformation();





    }
}
