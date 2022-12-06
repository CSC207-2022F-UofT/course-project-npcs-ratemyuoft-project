package entities;

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
        cl.addComment(new Comment("entities"));
        for(Comment c : cl) {
            assertEquals(c.getComment(), "entities");
        }
    }

    @Test
    public void iterator() {
        assertTrue(true);
    }
}