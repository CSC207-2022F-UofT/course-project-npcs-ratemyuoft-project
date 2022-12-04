import filterUseCases.CourseDataAccessInterface;
import courseDataBase.CourseDataAccess;

import java.io.IOException;

public class dataFill {
    public static void main(String[] args) throws IOException {
        CourseDataAccessInterface dataBase = new CourseDataAccess();
        ((CourseDataAccess) dataBase).generateTempCourses2();
    }
}