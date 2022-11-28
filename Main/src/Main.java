import DataBase.DataAccess;
import InterfaceAdapters.Controller;
import InterfaceAdapters.Presenter;
import InterfaceAdaptersL.ControllerL;
import InterfaceAdaptersL.PresenterL;
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
        DataAccess d1 = new DataAccess();


        Review r = new Review(4, "I hate this Course", "Review1");
        Review r1 = new Review(3, "This course is cool", "Review2");
        Review r2 = new Review(1, "This course is bird", "Review3");

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

        Presenter p = new Presenter();
        PresenterL pL = new PresenterL();

        Controller controla = new Controller("Mat137", d, p);
        //ControllerL controllaL = new ControllerL("Review1", d1, pL);

        //controllaL.Like();

        controla.Display();

    }
}
