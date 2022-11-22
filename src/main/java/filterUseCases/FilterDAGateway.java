package filterUseCases;

import entities.CourseList;

import java.io.IOException;
import java.util.NoSuchElementException;

public interface FilterDAGateway {

    CourseList importCourse() throws IOException, NoSuchElementException, ClassNotFoundException;

}
