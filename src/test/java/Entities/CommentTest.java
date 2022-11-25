package Entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {

    Comment c;
    Comment c1;


    @Before
    public void setUpClass() throws Exception {
         c = new Comment("hi");
         c1 = new Comment("bye");
        System.out.println(c1.getCommentNum());

    }

    @After
    public void tearDownClass() throws Exception {
        c = null;
        c1 = null;
    }

    @Test
    public void testToString() {
//        assertEquals(c,"ID : 1 Comment: hi");
    }

    @Test
    public void testGetCommentNum() {
        assertEquals(c.getCommentNum(),1);
    }

    @Test
    public void testGetComment() {
        assertEquals(c.getComment(),"hi");
    }

    @Test
    public void testSetComment() {
        c.setComment("bye");
        assertEquals(c.getComment(),"bye") ;
    }

}