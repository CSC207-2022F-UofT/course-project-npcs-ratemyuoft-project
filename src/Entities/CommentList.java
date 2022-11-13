package Entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CommentList implements Iterable<List<Comment>> {

    private List<Comment> commentlist = new ArrayList<>();

    public void addComment(Comment c){
        commentlist.add(c);
    }

    @Override
    public Iterator<List<Comment>> iterator() {
        return new CommentListIterator();

    }

    private class CommentListIterator implements Iterator<List<Comment>> {
        private int curr;


        @Override
        public boolean hasNext() {
            return curr < commentlist.size();
        }

        @Override
        public List<Comment> next() {
            List<Comment> temp = new ArrayList<>();
            while (hasNext()) {
                temp.add(commentlist.get(curr++));
            }
            if (temp.size()> 0) {
                return temp;
            }
            throw new NoSuchElementException();
        }
    }
}

