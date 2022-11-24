package DataBase;

import Usecase.Gateway;
import entity.CourseList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

public class DataAccess implements Gateway {
    private static final String fileName = "Database.sav";

    @Override
    public CourseList importcourselist() throws IOException, ClassNotFoundException {


        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileIn);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null){
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new CourseList());

        }
        CourseList newCourseList = (CourseList) inputStream.readObject();
        return newCourseList;
    }

    public void saveComment(CourseList commentList) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        outputStream.writeObject(commentList);
        fileOut.close();
    }
}
