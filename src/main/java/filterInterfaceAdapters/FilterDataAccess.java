package filterInterfaceAdapters;

import entities.CourseList;
import filterUseCases.FilterDAGateway;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.NoSuchElementException;

public class FilterDataAccess implements FilterDAGateway {

    private static final String fileName = "CourseFile.sav";
    @Override
    public CourseList importCourse() throws IOException, NoSuchElementException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileIn);
        return (CourseList) inputStream.readObject();
    }
}
