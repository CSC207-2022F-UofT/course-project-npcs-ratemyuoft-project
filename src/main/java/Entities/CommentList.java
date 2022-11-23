package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CommentList implements Iterable<Comment>, Serializable {

    private List<Comment> commentlist = new ArrayList<>();

    public void addComment(Comment c){
        commentlist.add(c);
    }




    @Override
    public Iterator<Comment> iterator() {
        return new CommentIterator();

    }

    private class CommentIterator implements Iterator<Comment> {
        private int curr;


        @Override
        public boolean hasNext() {
            return curr < commentlist.size();
        }

        @Override
        public Comment next() {
           if(hasNext()){
               return commentlist.get(curr ++);
           }
           throw new NoSuchElementException();
        }
    }
}

