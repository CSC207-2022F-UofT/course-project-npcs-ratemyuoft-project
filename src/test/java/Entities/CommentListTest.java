package Entities;

import Entities.Comment;
import Entities.CommentList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentListTest {
    CommentList cl;

    @Before
    public void setUp() throws Exception {
        cl = new CommentList();
    }

    @After
    public void tearDown() throws Exception {
        cl =null;
    }

    @Test
    public void addComment() {
        cl.addComment(new Comment("hi"));
        for(Comment c : cl) {
            assertEquals(c.getComment(),"hi");
        }
    }

    @Test
    public void iterator() {
        assertEquals(true,true);
    }
}