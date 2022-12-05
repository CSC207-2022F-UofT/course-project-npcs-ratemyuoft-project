package dataBase;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import entities.Course;
import entities.CourseList;
import usecase.CourseDataAccessInterface;
import usecase.InvalidInputException;

/**
 * Database class is an implementation of the DataAccess interface that is located in package useCase
 * <p>
 * Its task is to create .sav file which is used as a database. Update the database and pass the data from it
 * to a CourseList.
 */
public class CourseDataAccess implements CourseDataAccessInterface {

    private final String fileName = "courseFile.sav";
    private List<Course> courses;

    private List<String> courseNames;


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
        for(Course c: courses) {
            this.courses.add(c);
            this.courseNames.add(c.getCourseName());
        }

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
    public CourseList importCourseList() throws IOException, ClassNotFoundException{

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null) {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new CourseList());
        }
        return (CourseList) inputStream.readObject();
    }

    public void generateTempCourses() throws IOException, NullPointerException{
        CourseList cl = new CourseList();
        for (int i = 1; i<=10; i++){
            Course course = new Course(Integer.toString(i), Integer.toString(i*10));
            cl.addCourse(course);
        }
        this.saveCourse(cl);
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
        try {
            this.saveCourse(cl);
        }catch (NullPointerException e ) {
            System.out.println("NullPointerException raised when generating temp courses");

        }
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public List<String> getCourseNames() {
        return this.courseNames;
    }

    @Override
    public Course getCourseWithName(String s) throws InvalidInputException {
        for (Course c : courses) {
            if (c.courseName.equals(s)) {
                return c;
            }
        } throw new InvalidInputException();

    }
}