package filterUseCases;
import entities.Course;

import java.util.List;

public interface FilterOutputBoundary {

    String outputMessage();

    List<Course> outputCourse();
}
