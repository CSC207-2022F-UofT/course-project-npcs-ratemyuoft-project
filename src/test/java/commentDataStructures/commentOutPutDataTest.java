package commentDataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class commentOutPutDataTest {
    commentOutPutData testCommentOutPutData;

    /**
     * Create a new list and create a new output data
     */
    @Before
    public void setUp()  {
        String s = "entities";
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        testCommentOutPutData = new commentOutPutData(list);

    }

    /**
     * Change output data in to null.
     */
    @After
    public void tearDown() {
        testCommentOutPutData = null;
    }


    /**
     * assert true faster getter method works
     */
    @Test
    public void getComments() {
        assertEquals("entities", testCommentOutPutData.getComments().get(0));
    }
}