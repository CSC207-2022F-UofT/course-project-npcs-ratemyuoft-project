package LikeReviewShawn;

import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;
import java.util.Objects;


public class LikeReview implements InputBoundaryL {
    public Review review;
    public CourseList courseList;
    public UsecaseShawn.Gateway gatewayView;
    public OutputBoundaryL output;

    public int iter;
    public Course cs;

    public LikeReview(String ReviewName, UsecaseShawn.Gateway gatewayView, OutputBoundaryL output) {

        this.gatewayView = gatewayView;
        this.output = output;

        try {
            this.courseList = this.gatewayView.importcourselist();
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }

        for (Course i : courseList) {
            int iterator = -1;
            System.out.println(i.reviews);
            for (Review r : i.GetReviews()) {
                iterator += 1;
                if (Objects.equals(r.Name, ReviewName)) {
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
        this.gatewayView.SaveCourse(this.courseList);

        //this.output.outputMessage("Course Liked");
            //System.out.println(this.review.numberOfLikes);
    }
}
