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
     */
    private final List<Course> courseList = new ArrayList<>();

    //Getter
    public List<Course> getCourseList() {
        return this.courseList;
    }

    //Setter
    public void addCourse(Course course) {
        courseList.add(course);
    }

    /**
     * Getter of the size of the courseList
     * @return the number of courses there is in the CourseList
     */
    public int size(){
        return getCourseList().size();
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
}