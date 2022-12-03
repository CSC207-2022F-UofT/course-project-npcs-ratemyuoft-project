package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CommentList implements Iterable<Comment>, Serializable {

    private final List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment c){
        commentList.add(c);
    }
    public String getComment(int index){
            return commentList.get(index).getComment();
    }


    /**
     * @return
     * Iterator class so I can use for each method
     */
    @Override
    public Iterator<Comment> iterator() {
        return new CommentIterator();

    }

    private class CommentIterator implements Iterator<Comment> {
        private int curr;


        @Override
        public boolean hasNext() {
            return curr < commentList.size();
        }

        @Override
        public Comment next() {
           if(hasNext()){
               return commentList.get(curr ++);
           }
           throw new NoSuchElementException();
        }
    }
}

