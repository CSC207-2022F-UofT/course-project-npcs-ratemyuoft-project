package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseList implements Iterable<Course>, Serializable {

    private List<Course> courseList = new ArrayList<>();


    public List<Course> getCourseList() {
        return this.courseList;
    }
    public void addCourse(Course course) {
        courseList.add(course);
    }


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