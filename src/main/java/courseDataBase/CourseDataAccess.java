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
//        try {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
//        }catch (EOFException e){
//            CourseList newUL = new CourseList();
//            this.saveCourse(newUL);
//        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null) {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new CourseList());
        }
        return (CourseList) inputStream.readObject();
    }

//    public void generateTempCourses() throws IOException, NullPointerException{
//        CourseList cl = new CourseList();
//        for (int i = 1; i<=10; i++){
//            Course course = new Course(Integer.toString(i), Integer.toString(i*10));
//            cl.addCourse(course);
//        }
//        this.saveCourse(cl);
//    }


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

//    public void CreateInstance() throws IOException, ClassNotFoundException {
//        CourseDataAccessInterface d = new CourseDataAccess();
//        Review r = new Review(4, "I hate this Course", "Review1");
//        Review r1 = new Review(3, "This course is cool", "Review2");
//        Review r2 = new Review(1, "This course is bird", "Review3");
//        Review r3 = new Review(1, "This course is bird", "Review4");
//        Review r4 = new Review(1, "This course is bird", "Review5");
//
//        Course mat = new Course("Mat137", "Math");
//        Course cs = new Course("CSC108", "Math");
//        Course stats = new Course("Sta257", "Math");
//
//        mat.addReview(r);
//        mat.addReview(r1);
//        mat.addReview(r2);
//
//        cs.addReview(r3);
//        stats.addReview(r4);
//
//        CourseList cl = new CourseList();
//        cl.addCourse(mat);
//        cl.addCourse(cs);
//        cl.addCourse(stats);
//
//    }
}
