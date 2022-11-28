import DataBase.DataAccess;
import InterfaceAdapters.Controller;
import InterfaceAdapters.Presenter;
import InterfaceAdaptersL.ControllerL;
import InterfaceAdaptersL.PresenterL;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataAccess d = new DataAccess();
        PresenterL pL = new PresenterL();
        Presenter p = new Presenter();

        Review r = new Review(4, "I hate this Course", "Review1");
        Course mat = new Course("Mat137", "Math");

        CourseList cl = new CourseList();
        cl.AddCourse(mat);
        d.SaveCourse(cl);
        mat.AddReview(r);
        d.SaveCourse(cl);

        ControllerL controllaL = new ControllerL("Review1", d, pL);
        Controller controla = new Controller("Mat137", d, p);
        
        controllaL.Like();
        controla.Display();






    }
}
