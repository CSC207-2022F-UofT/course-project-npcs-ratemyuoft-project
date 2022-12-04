import courseDataBase.CourseDataAccess;

import java.io.IOException;

public class dataFill {
    public static void main(String[] args) throws IOException {
        CourseDataAccess dataBase = new CourseDataAccess();
        dataBase.generateTempCourses2();
    }
}