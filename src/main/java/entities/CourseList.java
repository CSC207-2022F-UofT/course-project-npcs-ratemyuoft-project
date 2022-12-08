package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * CourseList is the added data structure for Courses
 * In our program, when working with data access and database features, it is usually a list of courses that is dealt with.
 * To better and more conveniently access and manipulate our data. We created a new class composed of Courses
 */
public class CourseList implements Iterable<Course>, Serializable {
    /**
     * CourseList class has one instance variable of type List<Course>
     * CourseList class has one instance of type List<String>
     */
    private final List<Course> courseList = new ArrayList<>();

    private final List<String> courseNameList = new ArrayList<>();

    //Setter
    public void addCourse(Course course) {
        courseList.add(course);
        courseNameList.add(course.getCourseName());
    }

    /**
     * CourseList class implements the Iterable and Serializable interface. To implement the interface, we have to first
     * instantiate an iterator and override the interable interface methods.
     */
    @Override
    public Iterator<Course> iterator() {
        return new CourseIterator();
    }

    private class CourseIterator implements Iterator<Course> {
        private int curr;

        @Override
        public boolean hasNext() {
            return curr < courseList.size();
        }

        @Override
        public Course next() {
            if (hasNext()) {
                return courseList.get(curr++);
            }
            throw new NoSuchElementException();
        }
    }

    // Getters

    /**
     *
     * @return This function returns a list of all the names of courses in this courseList.
     * @throws ClassNotFoundException It returns this exception if the courseList is empty.
     */
    public List<String> getCourseNameList() throws ClassNotFoundException{

        if (!(courseNameList.isEmpty())){
            return courseNameList;
        }else {
            throw new ClassNotFoundException();
        }
    }

    /**
     *
     * @return This function returns a boolean that is true if the CourseList has no courses in it.
     */
    public boolean isEmpty() {
        return (courseList.isEmpty());
    }

    /**
     *
     * @return This function returns the list of courses in this CourseList.
     */
    public List<Course> getCourseList() {
        return this.courseList;
    }

    /**
     * Getter of the size of the courseList
     * @return the number of courses there is in the CourseList
     */
    public int size(){
        return getCourseList().size();
    }

    /**
     * This function returns the course in this CourseList with the name s.
     *
     * @param s This is the name of the course this function will return.
     * @return This is the course that has name provided in the argument.
     * It throws a class not found exception if there is no course with the name provided or if the courseList is empty.
     */
    public Course getCourseWithName(String s) throws ClassNotFoundException {
        if (this.containsCourseWithName(s)){
            for (Course c: courseList) {
                if (c.getCourseName().equals(s)) {
                    return c;
                }
            }
        }else throw new NoSuchElementException();
        return null;
    }

    /**
     * This function returns true if this CourseList contains a course with the name s
     * @param s This is the name of the Course we wish to check
     * @return This is true if this CourseList contains a course with the name s and false otherwise.
     * @throws ClassNotFoundException This is thrown if the courseList is empty
     */
    public boolean containsCourseWithName(String s) throws ClassNotFoundException {
        return this.getCourseNameList().contains(s);
    }
}