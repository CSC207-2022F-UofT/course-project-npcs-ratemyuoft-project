package likeReviewUsecase;

import courseDataBase.CourseDataBaseGateway;

import entities.Course;
import entities.CourseList;
import entities.Review;

import java.io.IOException;
import java.util.Objects;


public class LikeReviewInteracter implements LikeReviewInputBoundary {
    public Review review;
    public CourseList courseList;
    public CourseDataBaseGateway courseDataBaseGateway;
    public LikeReviewOutputBoundary output;

    public int iter;
    public Course cs;

    public LikeReviewInteracter(String reviewName, CourseDataBaseGateway courseDataBaseGateway, LikeReviewOutputBoundary output) {

        this.courseDataBaseGateway = courseDataBaseGateway;
        this.output = output;

        try {
            this.courseList = this.courseDataBaseGateway.importCourses();
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }

        for (Course i : courseList) {
            int iterator = -1;
            System.out.println(i.reviews);
            for (Review r : i.getReviews()) {
                iterator += 1;
                if (Objects.equals(r.Name, reviewName)) {
                    cs = i;
                    iter = iterator;
                    break;
                    //this.output.outputMessage("Course Liked");
                }
            }
        }
    }
        //if (this.review == null){
        //    this.output.outputMessage("NO Review With This Name");
        //}
        //}

    @Override
    public void AddLike () throws IOException, ClassNotFoundException {
        cs.reviews.get(iter).Like();
        this.courseDataBaseGateway.saveCourse(this.courseList);

        //this.output.outputMessage("Course Liked");
            //System.out.println(this.review.numberOfLikes);
    }
}
