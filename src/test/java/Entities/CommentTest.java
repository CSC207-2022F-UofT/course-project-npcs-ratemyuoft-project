package entities;

import org.junit.*;

import static org.junit.Assert.*;

public class CommentTest {

    static Comment c1;
    static Comment c2;

    /**
     * Create new comment before the comment test
     */
    @BeforeClass
    public static void setUp()  {
        Comment.resetCount();
        c1 = new Comment("hi");
        c2 = new Comment("bye");
    }

    /**
     * Set everything into null
     */
    @AfterClass
    public static void tearDown()  {
         c1 = null;
         c2 = null;
    }

    /**
     * Text to string method
     */
    @Test
    public void testToString() {
        assertEquals( "ID :1 Comment: hi", c1.toString());
        assertEquals( "ID :2 Comment: bye", c2.toString());
    }

    /**
     * Test comment number for each comment
     */
    @Test
    public void testGetCommentNum() {
        assertEquals(1,c1.getCommentNum());
        assertEquals(2,c2.getCommentNum());
    }

    /**
     * Test get comment
     */
    @Test
    public void testGetComment() {
        assertEquals("hi", c1.getComment());
        assertEquals("bye", c2.getComment());
    }

    @Test
    public void testSetComment() {
        assertEquals("bye",c2.getComment()) ;
    }

}