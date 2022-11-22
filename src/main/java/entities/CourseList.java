package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseList implements Iterable<Course>{

    private List<Course> courselist = new ArrayList<>();

    public void addCourse(Course course) {
        courselist.add(course);
    }

    @Override
    public Iterator<Course> iterator() {
        return new CourseIterator();

    }

    public List<Course> getCourselist(){
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
            if(hasNext()){
                courselist.get(curr ++);
            }
            throw new NoSuchElementException();
        }
    }

//    public Course getCourse(String name){
//        for(Course c : courselist){
//            if (c.courseName == name){
//                return c;
//            }
//        }
//    }
}
