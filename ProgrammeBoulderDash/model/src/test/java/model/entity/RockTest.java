package model.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RockTest {

    private Rock test;
    @Before
    public void setUp()  {
        test = new Rock(1,3);
    }

    @After
    public void tearDown()  {
    }

    @Test
    public void existing() throws Exception{
        final boolean exception=true;
        assertEquals(exception,test.getExisting());
    }

    @Test
    public void falling() throws Exception{
        final boolean exception=false;
        assertEquals(exception,test.getFalling());
    }

}