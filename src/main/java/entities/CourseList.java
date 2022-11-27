package entities;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseList implements Iterable<Course> {

    private List<Course> courselist = new ArrayList<>();

    public void addCourse(Course course) {
        courselist.add(course);
    }

    @Override
    public Iterator<Course> iterator() {
        return new CourseIterator();

    }

    private class DataFill {
        public DataFill() {
            CourseList cl = new CourseList();
            Course course = new Course("ahdsjhadsj", "sdhakjhdj");

            cl.addCourse(course);
        }
    }

    DataFill datafill = new DataFill();

    public List<Course> getCourselist() {
        return this.courselist;
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
                courselist.get(curr++);
            }
            throw new NoSuchElementException();
        }
    }
}