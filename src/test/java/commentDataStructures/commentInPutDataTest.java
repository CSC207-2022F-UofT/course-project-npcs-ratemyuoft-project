package commentDataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class commentInPutDataTest {
    commentInPutData testCommentInPutData;

    /**
     * Set up a new input data
     */
    @Before
    public void setUp()  {
        testCommentInPutData = new commentInPutData("entities");

    }

    /**
     * Change input data into null
     */
    @After
    public void tearDown()  {
        testCommentInPutData = null;

    }

    /**
     * True if input data get comment matches expected
     */
    @Test
    public void getComments() {
        assertEquals("entities", testCommentInPutData.getComments());
    }
}