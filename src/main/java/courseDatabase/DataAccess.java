package courseDatabase;

import registerCourse.RegisterCourse2;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

public class DataAccess implements viewCourseReviewUseCase.Gateway {
    // Contains a Database, Saves to it and imports from it
    private static final String fileName = "Database18.sav";

    @Override
    public CourseList importcourselist() throws IOException, ClassNotFoundException {
        // Imports from the Database and outputs a Courselist Data type
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileIn);

        CourseList newCourseList = (CourseList) inputStream.readObject();
        return newCourseList;
    }

    public void SaveCourse(CourseList commentList) throws IOException, ClassNotFoundException {
        // Takes in a courselist and saves it to our Database.
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        outputStream.writeObject(commentList);
        fileOut.close();
    }

    public void CreateInstance() throws IOException, ClassNotFoundException {
        DataAccess d = new DataAccess();
        Review r = new Review(4, "I hate this Course", "Review1");
        Review r1 = new Review(3, "This course is cool", "Review2");
        Review r2 = new Review(1, "This course is bird", "Review3");
        Review r3 = new Review(1, "This course is bird", "Review4");
        Review r4 = new Review(1, "This course is bird", "Review5");

        Course mat = new Course("Mat137", "Math");
        Course cs = new Course("CSC108", "Math");
        Course stats = new Course("Sta257", "Math");

        mat.AddReview(r);
        mat.AddReview(r1);
        mat.AddReview(r2);

        cs.AddReview(r3);
        stats.AddReview(r4);

        CourseList cl = new CourseList();
        cl.AddCourse(mat);
        cl.AddCourse(cs);
        cl.AddCourse(stats);

        RegisterCourse2 reg = new RegisterCourse2(cl, d);
    }
}
