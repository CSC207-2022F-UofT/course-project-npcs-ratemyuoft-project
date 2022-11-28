package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseList implements Iterable<Course>, Serializable {

    private List<Course> courselist = new ArrayList<>();

    public List<Course> getCourselist() {
        return this.courselist;
    }

    public void addCourse(Course course) {
        courselist.add(course);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Course c : courselist){
            sb.append("COURSE " + Integer.toString(i) + ": " + c.toString() + '\n');
            i += 1;
        }
        return sb.toString();
    }

    @Override
    public Iterator<Course> iterator() {
        return new CourseIterator();

    }

    private class CourseIterator implements Iterator<Course> {
        private int curr;


        @Override
        public boolean hasNext() {
            return curr < courselist.size();
        }

        @Override
        public Course next() {
            if (hasNext()) {
                return courselist.get(curr++);
            }
            throw new NoSuchElementException();
        }
    }
}