package DataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InPutDataTest {
    InPutData testInPutData;

    /**
     * Set up a new input data
     */
    @Before
    public void setUp()  {
        testInPutData = new InPutData("hi");

    }

    /**
     * Change input data into null
     */
    @After
    public void tearDown()  {
        testInPutData = null;

    }

    /**
     * True if input data get comment matches expected
     */
    @Test
    public void getComments() {
        assertEquals("hi",testInPutData.getComments());
    }
}