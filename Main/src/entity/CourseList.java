package entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CourseList implements Serializable, Iterable<Course> {
    public ArrayList<Course> Courses = new ArrayList<>();
    public void AddCourse(Course course){
        this.Courses.add(course);
    }

    public Iterator<Course> iterator() {
        return new CourseIterator();
    }

    private class CourseIterator implements Iterator<Course>{
        private int curr;

        @Override
        public boolean hasNext(){
            return curr < Courses.size();
        }

        @Override
        public Course next() {
            if(hasNext()){
                return Courses.get(curr++);
            }
            throw new NoSuchElementException();
        }

    }

}
