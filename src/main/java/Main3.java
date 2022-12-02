import courseDataBase.CourseDataAccess;

import filterUseCases.CourseDataAccessInterface;
import viewCourseInterfaceAdapters.ViewCourseController;
import viewCourseInterfaceAdapters.ViewCoursePresenter;
import likeReviewInterfaceAdapters.LikeReviewController;
import likeReviewInterfaceAdapters.LikeReviewPresenter;

import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CourseDataAccessInterface d = new CourseDataAccess();

        ViewCoursePresenter p = new ViewCoursePresenter();
        LikeReviewPresenter pL = new LikeReviewPresenter();

        LikeReviewController controllaL = new LikeReviewController("Review4", d, pL);
        ViewCourseController controla = new ViewCourseController("CSC108", d, p);

        controllaL.Like();
        controla.displayCourseDetails();
    }
}
