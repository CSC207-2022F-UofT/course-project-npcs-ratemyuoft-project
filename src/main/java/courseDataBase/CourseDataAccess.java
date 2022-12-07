package courseDataBase;

import java.io.*;

import entities.Course;
import entities.CourseList;
import entities.Review;
import filterUseCases.CourseDataAccessInterface;


/**
 * Database class is an implementation of the DataAccess interface that is located in package useCase
 * <p>
 * Its task is to create .sav file which is used as a database. Update the database and pass the data from it
 * to a CourseList.
 */
public class CourseDataAccess implements CourseDataAccessInterface {

    private final String fileName = "courseFile.sav";

    /**
     * @param courses is the UserList that has all the courses
     * @throws IOException .
     * @throws NullPointerException
     *
     * both Exceptions are used for debugging and restricting purposes
     * <p>
     *
     * saveUser accepts courses and writes it to userFile.sav
     */
    @Override
    public void saveCourse(CourseList courses) throws IOException, NullPointerException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(courses);
        outputStream.close();

    }

    /**
     * importUsers method:
     *
     * @return UserList consisting of all users that are currently in userFile.sav
     * @throws IOException .
     * @throws ClassNotFoundException
     * both Exceptions are used for debugging and restricting purposes
     */
    @Override
    public CourseList importCourses() throws IOException, ClassNotFoundException{

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null) {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new CourseList());
        }
        return (CourseList) inputStream.readObject();
    }


    public void generateTempCourses2() throws IOException, NullPointerException {
        CourseList cl = new CourseList();
        Course course1 = new Course("MAT137", "Mathematics");
        Course course2 = new Course("MAT223", "Mathematics");
        Course course3 = new Course("MAT224", "Mathematics");
        Course course4 = new Course("MAT135", "Mathematics");
        Course course5 = new Course("MAT157", "Mathematics");
        Course course6 = new Course("CSC108", "Computer Science");
        Course course7 = new Course("CSC148", "Computer Science");
        Course course8 = new Course("STA257", "Statistical Science");
        Course course9 = new Course("STA261", "Statistical Science");
        Course course10 = new Course("STA130", "Statistical Science");

        Review r1 = new Review(3, "Good Course", "review1");
        Review r2 = new Review(3, "Good Course", "review2");
        Review r3 = new Review(3, "Good Course", "review3");
        Review r4 = new Review(3, "Good Course", "review4");
        Review r5 = new Review(3, "Good Course", "review5");
        Review r6 = new Review(3, "Good Course", "review6");
        Review r10 = new Review(3, "Good Course", "review7");
        Review r7 = new Review(3, "Good Course", "review8");
        Review r8 = new Review(3, "Good Course", "review9");
        Review r9 = new Review(3, "Good Course", "review10");

        course1.addReview(r1);
        course2.addReview(r2);
        course3.addReview(r3);
        course4.addReview(r4);
        course5.addReview(r5);
        course6.addReview(r6);
        course7.addReview(r7);
        course8.addReview(r8);
        course9.addReview(r9);
        course10.addReview(r10);


        cl.addCourse(course9);
        cl.addCourse(course4);
        cl.addCourse(course2);
        cl.addCourse(course8);
        cl.addCourse(course3);
        cl.addCourse(course6);
        cl.addCourse(course10);
        cl.addCourse(course5);
        cl.addCourse(course1);
        cl.addCourse(course7);
        int i = 0;
        for (Course c : cl) {
            c.setCourseRating(i);
            i += 1;
        }
        this.saveCourse(cl);
    }


}
