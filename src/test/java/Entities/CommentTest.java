package Entities;

import org.junit.*;

import static org.junit.Assert.*;

public class CommentTest {

    static Comment c1;
    static Comment c2;

    @BeforeClass
    public static void setUp()  {
        Comment.resetCount();
        c1 = new Comment("hi");
        c2 = new Comment("bye");
    }

    @AfterClass
    public static void tearDown()  {
         c1 = null;
         c2 = null;
    }

    @Test
    public void testToString() {
        assertEquals( "ID :1 Comment: hi", c1.toString());
        assertEquals( "ID :2 Comment: bye", c2.toString());
    }

    @Test
    public void testGetCommentNum() {
        assertEquals(1,c1.getCommentNum());
        assertEquals(2,c2.getCommentNum());
    }

    @Test
    public void testGetComment() {
        assertEquals("hi", c1.getComment());
    }

    @Test
    public void testSetComment() {
        assertEquals("bye",c2.getComment()) ;
    }

}