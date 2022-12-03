package likeReviewUseCase;

import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;
import java.util.Objects;


public class LikeReview implements InputBoundaryL {
    public Review review;
    public CourseList courseList;
    public viewCourseReviewUseCase.Gateway gatewayView;
    public OutputBoundaryL output;

    public int iter;
    public Course cs;

    public LikeReview(viewCourseReviewUseCase.Gateway gatewayView, OutputBoundaryL output) {

        this.gatewayView = gatewayView;
        this.output = output;

        try {
            this.courseList = this.gatewayView.importcourselist();
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }

    }
    @Override
    public void AddLike (String reviewname) throws IOException, ClassNotFoundException {
        Boolean liked = Boolean.FALSE;
        for (Course i : this.courseList) {
            int iterator = -1;
            for (Review r : i.GetReviews()) {
                iterator += 1;
                if (Objects.equals(r.Name, reviewname)) {
                    cs = i;
                    iter = iterator;
                    liked = Boolean.TRUE;
                    break;
                }
            }
        }

        cs.reviews.get(iter).Like();
        this.gatewayView.SaveCourse(this.courseList);

        if (liked == Boolean.TRUE){
            this.output.outputMessage(new LikeMessageRequestModel(reviewname));
        }
        else{
            this.output.outputMessage(new LikeMessageRequestModel("No Review With this Name"));
        }

    }
}
