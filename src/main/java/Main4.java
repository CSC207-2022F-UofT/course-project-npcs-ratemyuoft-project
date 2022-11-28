import courseDataBase.CourseDataAccess;
import courseDataBase.CourseDataBaseGateway;
import viewCourseInterfaceAdapters.ViewCourseController;
import viewCourseInterfaceAdapters.ViewCoursePresenter;
import likeReviewInterfaceAdapters.LikeReviewController;
import likeReviewInterfaceAdapters.LikeReviewPresenter;
import entities.Course;
import entities.CourseList;
import entities.Review;
import viewCourseUsecase.ViewCourseInputBoundary;
import viewCourseUsecase.ViewCourseInteracter;

import java.io.IOException;

public class Main4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CourseDataBaseGateway d = new CourseDataAccess();
        LikeReviewPresenter pL = new LikeReviewPresenter();
        ViewCoursePresenter p = new ViewCoursePresenter();

        Review r = new Review(4, "I hate this Course", "Review1");
        Course mat = new Course("Mat137", "Math");

        CourseList cl = new CourseList();
        cl.addCourse(mat);
        d.saveCourse(cl);
        mat.addReview(r);
        d.saveCourse(cl);

        LikeReviewController controllaL = new LikeReviewController("Review1", d, pL);
        ViewCourseController controla = new ViewCourseController("Mat137", d, p);
        
        controllaL.Like();
        controla.displayCourseDetails();

    }
}
