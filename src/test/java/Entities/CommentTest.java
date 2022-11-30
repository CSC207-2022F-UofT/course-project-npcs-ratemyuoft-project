package Entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {

    Comment c;
    Comment c1;


    @Before
    public void setUp() throws Exception {

         c = new Comment("hi");
         c1 = new Comment("bye");
        System.out.println("new");


    }

    @After
    public void tearDown() throws Exception {
        c = null;
        c1 = null;
    }

    @Test
    public void testToString() {
        assertEquals( "ID :1 Comment: hi", c.toString());
        assertEquals( "ID :1 Comment: bye", c1.toString());
    }

    @Test
    public void testGetCommentNum() {

        assertEquals(1,c.getCommentNum());
        assertEquals(2,c1.getCommentNum());
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