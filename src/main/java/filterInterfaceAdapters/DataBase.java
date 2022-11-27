package filterInterfaceAdapters;

import java.io.*;

import filterUseCases.FilterDAGateway;
import entities.CourseList;

/**
 * Database class is an implementation of the DataAccess interface that is located in package useCase
 * <p>
 * Its task is to create .sav file which is used as a database. Update the database and pass the data from it
 * to a CourseList.
 */
public class DataBase implements FilterDAGateway {

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
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        }catch (EOFException e){
            CourseList newUL = new CourseList();
            this.saveCourse(newUL);
        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null) {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new CourseList());
        }

        return (CourseList) inputStream.readObject();

    }
}
