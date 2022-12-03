package Entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommentListTest {
    CommentList cl;

    @Before
    public void setUp()  {
        cl = new CommentList();
    }

    @After
    public void tearDown()  {
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
        assertTrue(true);
    }
}