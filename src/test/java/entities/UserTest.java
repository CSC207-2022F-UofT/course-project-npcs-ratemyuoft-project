package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User u =new User("mykola", "qwerty", "math",2020);

    @Test
    void getUserNameTest() {
        assertEquals("mykola", u.getUserName(),"getUserName doesn't work properly");
    }

    @Test
    void getPasswordTest() {
        assertEquals("qwerty", u.getPassword(),"getPassword doesn't work properly");
    }

    @Test
    void getStartYearOfStudyTest() {
        assertEquals(2020, u.getStartYearOfStudy(),"getStartYearOfStudy doesn't work properly");
    }

    @Test
    void getMajorTest() {
        assertEquals("math", u.getMajor(),"getMajor doesn't work properly");
    }

    @Test
    void getLogInStatusTest() {
        assertFalse( u.getLogInStatus(),"getLogInStatus doesn't work properly");
    }

    @Test
    void setLogInStatusTest() {
        u.setLogInStatus(true);
        assertTrue(u.getLogInStatus(), "setLogInStatus doesn't work properly");
    }
}