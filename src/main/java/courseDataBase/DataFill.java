package courseDatabase;

import java.io.IOException;

public class DataFill {
    public DataFill(){
        CourseDataAccess dataBase = new CourseDataAccess();
        try {
            dataBase.generateTempCourses2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}