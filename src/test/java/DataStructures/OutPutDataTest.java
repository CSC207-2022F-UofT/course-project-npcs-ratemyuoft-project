package DataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OutPutDataTest {
    OutPutData testOutPutData;

    @Before
    public void setUp()  {
        String s = "hi";
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        testOutPutData = new OutPutData(list);

    }

    @After
    public void tearDown() {
        testOutPutData = null;
    }

    @Test
    public void getComments() {
        assertEquals("hi",testOutPutData.getComments().get(0));
    }
}