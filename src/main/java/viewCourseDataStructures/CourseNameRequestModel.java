package viewCourseDataStructures;

public class CourseNameRequestModel {
    /**
     * CourseNameRequestModel Takes in a Value for a coursename and Stores it in a String Data Type.
     */

    String coursename;

    public CourseNameRequestModel(String coursename){
        this.coursename = coursename;
    }

    public String getCoursename(){
        return this.coursename;
    }
}
